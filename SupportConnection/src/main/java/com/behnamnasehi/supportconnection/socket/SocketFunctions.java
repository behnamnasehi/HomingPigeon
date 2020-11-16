package com.behnamnasehi.supportconnection.socket;

import android.content.Context;
import android.text.TextUtils;

import com.behnamnasehi.supportconnection.db.SessionManager;
import com.behnamnasehi.supportconnection.interfaces.SocketInterface;
import com.behnamnasehi.supportconnection.utilitis.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class SocketFunctions implements SocketInterface {
     private Context context;
    private SessionManager sessionManager;
    private boolean isUserRegistered = false;

    public SocketFunctions(Context context) {

        this.context = context;
        sessionManager = new SessionManager(context);
    }

    @Override
    public Socket initialize(IO.Options options) throws URISyntaxException {
        return IO.socket(Constant.BASE_URL, options);
    }

    @Override
    public void sendMessage(Socket socket , String msg ) {
        socket.emit(Constant.EVENT_TAG_MESSAGE, msg);
    }




}
