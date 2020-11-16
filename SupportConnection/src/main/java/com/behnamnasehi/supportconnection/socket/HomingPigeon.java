package com.behnamnasehi.supportconnection.socket;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.util.Log;

import com.behnamnasehi.supportconnection.controller.UserController;
import com.behnamnasehi.supportconnection.interfaces.Response;
import com.behnamnasehi.supportconnection.interfaces.SocketResponseInterface;
import com.behnamnasehi.supportconnection.model.HandShake;
import com.behnamnasehi.supportconnection.model.Message;
import com.behnamnasehi.supportconnection.network.RetrofitClient;
import com.behnamnasehi.supportconnection.utilitis.Constant;
import com.behnamnasehi.supportconnection.utilitis.Functions;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.socket.client.IO;
import io.socket.client.Socket;
import retrofit2.Call;
import retrofit2.Callback;

public class HomingPigeon implements HeartBeat.HeartBeatListener, SocketEventListener.Listener {
    private static final String TAG = HomingPigeon.class.getSimpleName();
    private Socket mSocket;
    private Boolean isConnected = true;
    private boolean mTyping;
    private Looper mServiceLooper;
    private HeartBeat heartBeat;
    private ConcurrentHashMap<String, SocketEventListener> listenersMap;
    private SocketFunctions socketFunctions;
    private String API_KEY;
    private SocketResponseInterface socketResponseInterface;
    private Gson gson;
    private Context CONTEXT;
    private Response netWorkResponse;


    public HomingPigeon(Context CONTEXT, String API_KEY, SocketResponseInterface socketResponseInterface) {
        this.API_KEY = API_KEY;
        this.socketResponseInterface = socketResponseInterface;
        this.CONTEXT = CONTEXT;
        init();
    }

    private IO.Options createIOOption() {
        IO.Options options = new IO.Options();
        UserController userController = new UserController(CONTEXT);
        HandShake handShake =
                userController.getUser().getIdentity() == null ?
                        new HandShake(API_KEY, userController.getUser().getSessionKey(), CONTEXT.getPackageName(), Build.BRAND + " " + Build.MODEL) :
                        new HandShake(API_KEY, userController.getUser().getSessionKey(), userController.getUser().getIdentity(), CONTEXT.getPackageName(), Build.BRAND + " " + Build.MODEL);
        options.query = "data=" + Functions.convertObjectToString(handShake);
        return options;
    }

    private void init() {
        gson = new Gson();
        socketFunctions = new SocketFunctions(CONTEXT);
        listenersMap = new ConcurrentHashMap<>();
        try {
            mSocket = socketFunctions.initialize(createIOOption());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        setSocketListeners();
        connectToSocket();
        heartBeat = new HeartBeat(this);
        heartBeat.start();
    }

    private void connectToSocket() {
        if (!isSocketConnected()) {
            mSocket.connect();
        }
    }

    private void setSocketListeners() {
        listenersMap.put(Socket.EVENT_CONNECT, new SocketEventListener(Socket.EVENT_CONNECT, this));
        listenersMap.put(Socket.EVENT_DISCONNECT, new SocketEventListener(Socket.EVENT_DISCONNECT, this));
        listenersMap.put(Socket.EVENT_CONNECT_ERROR, new SocketEventListener(Socket.EVENT_CONNECT_ERROR, this));
        listenersMap.put(Socket.EVENT_CONNECT_TIMEOUT, new SocketEventListener(Socket.EVENT_CONNECT_TIMEOUT, this));
        listenersMap.put(Constant.EVENT_TAG_MESSAGE, new SocketEventListener(Constant.EVENT_TAG_MESSAGE, this));
        listenersMap.put(Constant.EVENT_TAG_CHANGE, new SocketEventListener(Constant.EVENT_TAG_CHANGE, this));
        listenersMap.put(Constant.EVENT_TAG_ERROR, new SocketEventListener(Constant.EVENT_TAG_ERROR, this));
        listenersMap.put(Constant.EVENT_TAG_READY, new SocketEventListener(Constant.EVENT_TAG_READY, this));
        for (Map.Entry<String, SocketEventListener> entry : listenersMap.entrySet()) {
            mSocket.on(entry.getKey(), entry.getValue());
        }
    }

    private boolean isSocketConnected() {
        if (null == mSocket) {
            return false;
        }
        return isConnected && mSocket.connected();
    }

    public void destroyEveryThing() {
        mSocket.disconnect();
        heartBeat.stop();
        for (Map.Entry<String, SocketEventListener> entry : listenersMap.entrySet()) {
            mSocket.off(entry.getKey(), entry.getValue());
        }
    }

    public void sendMessage(String msg) {
        socketFunctions.sendMessage(mSocket, msg);
    }

    @Override
    public void onHeartBeat() {
        connectToSocket();
    }

    @Override
    public void onEventCall(String event, Object... args) {
        Log.e(TAG, "onEventCall: " + event);
        switch (event) {
            case Socket.EVENT_CONNECT:
                socketResponseInterface.onConnect();
                isConnected = true;
                break;
            case Socket.EVENT_DISCONNECT:
                socketResponseInterface.onDisconnect();
                isConnected = false;
                break;
            case Socket.EVENT_CONNECT_ERROR:
                socketResponseInterface.OnConnectError("On Connect Error");
                isConnected = false;
                break;
            case Socket.EVENT_CONNECT_TIMEOUT:
                socketResponseInterface.OnConnectError("Time Out");
                break;
            case Constant.EVENT_TAG_MESSAGE:
                JSONObject obj = (JSONObject) args[0];
                Message message = gson.fromJson(obj.toString(), Message.class);
                Log.e(TAG, "onEventCall: " + gson.toJson(message));
                socketResponseInterface.OnMessageDetection(message);
                break;
            case Constant.EVENT_TAG_ERROR:
                Log.e(TAG, "onEventCall: " + args[0]);
                socketResponseInterface.OnConnectError(createHandShakeFromObj(args[0]).getMessage());
                break;
            case Constant.EVENT_TAG_READY:
                socketResponseInterface.onReady();
                break;
        }
    }

    public void getMessageList(String roomId, String pageNumber, String limit, final Response networkResponse) {
        this.netWorkResponse = networkResponse;
        RetrofitClient.getNetworkConfiguration().requestMainResponse(roomId, pageNumber, limit).enqueue(new Callback<HandShake>() {
            @Override
            public void onResponse(Call<HandShake> call, retrofit2.Response<HandShake> response) {
                if (response.isSuccessful()) {
                    networkResponse.onDataReceived(response.body().getData().getMessageList());
                }
            }

            @Override
            public void onFailure(Call<HandShake> call, Throwable t) {

            }
        });
    }

    public void startActivityByStringName(Context context, String activityClassName) {
        context.startActivity(new Intent().setClassName(context, context.getPackageName() + "." + activityClassName));
    }

    private HandShake createHandShakeFromObj(Object json) {
        return gson.fromJson(gson.toJson(json), HandShake.class);
    }


}
