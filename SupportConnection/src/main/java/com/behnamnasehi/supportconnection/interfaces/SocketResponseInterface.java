package com.behnamnasehi.supportconnection.interfaces;

import com.behnamnasehi.supportconnection.model.HandShake;
import com.behnamnasehi.supportconnection.model.Message;

public interface SocketResponseInterface {

    void onConnect();

    void onReady();

    void onDisconnect();

    void OnConnectError(String msg);

    void OnMessageDetection(Message messageObj);

}
