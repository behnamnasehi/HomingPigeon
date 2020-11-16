package com.behnamnasehi.supportconnection.interfaces;

import com.behnamnasehi.supportconnection.model.HandShake;
import com.behnamnasehi.supportconnection.model.Message;

import java.util.List;

public interface Response {
    void onDataReceived(List<Message> list);
}
