package com.behnamnasehi.supportconnection.interfaces;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public interface SocketInterface {

    Socket initialize(IO.Options options) throws URISyntaxException;

    void sendMessage(Socket socket , String msg);

 }
