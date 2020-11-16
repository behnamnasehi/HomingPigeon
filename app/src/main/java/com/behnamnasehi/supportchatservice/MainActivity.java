package com.behnamnasehi.supportchatservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.behnamnasehi.supportconnection.controller.UserController;
import com.behnamnasehi.supportconnection.db.SessionManager;
import com.behnamnasehi.supportconnection.interfaces.Response;
import com.behnamnasehi.supportconnection.interfaces.SocketResponseInterface;
import com.behnamnasehi.supportconnection.model.HandShake;
import com.behnamnasehi.supportconnection.model.Message;
import com.behnamnasehi.supportconnection.socket.HomingPigeon;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppCompatActivity instance;
    private static final String TAG = "MainActivity";
    private TextView textView;
    private EditText editText;
    private Button btn ;
    String txt;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    private void finishActivity() {
        if (instance != null) instance.finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txt);
        editText = findViewById(R.id.ed);
        btn = findViewById(R.id.btn);
        instance = this;
        dataBindingUtils();
        UserController userController = new UserController(this);
        userController.updateUserIdentity("+989350805855");
        final HomingPigeon homingPigeon = new HomingPigeon(this, "02627a55-4cd2-4ac4-b5c1-07bc97142cf6", new SocketResponseInterface() {
            @Override
            public void onConnect() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txt += "Connected\n";
                        textView.setText(txt);
                    }
                });
            }

            @Override
            public void onReady() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txt += "Ready\n";
                        textView.setText(txt);
                    }
                });
            }

            @Override
            public void onDisconnect() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txt += "Disconnected\n";
                        textView.setText(txt);
                    }
                });
            }

            @Override
            public void OnConnectError(final String msg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txt += msg;
                        textView.setText(txt);
                    }
                });
            }

            @Override
            public void OnMessageDetection(final Message messageObj) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txt += messageObj.getBody() + "\n";
                        textView.setText(txt);
                    }
                });
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                homingPigeon.sendMessage(editText.getText().toString());

            }
        });

        homingPigeon.getMessageList("", "", "", new Response() {
            @Override
            public void onDataReceived(List<Message> list) {

            }
        });

    }

    private void dataBindingUtils() {

    }

    private Activity getCurrentActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        instance = null;
        super.onDestroy();
    }
}
 