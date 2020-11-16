package com.behnamnasehi.supportconnection.controller;

import android.content.Context;
import android.widget.Toast;

import com.behnamnasehi.supportconnection.db.SessionManager;
import com.behnamnasehi.supportconnection.model.User;
import com.behnamnasehi.supportconnection.security.AppSignatureHelper;
import com.behnamnasehi.supportconnection.utilitis.Constant;

public class UserController {
    Context context;
    SessionManager sessionManager;
    AppSignatureHelper appSignatureHelper;

    public UserController(Context context) {
        this.context = context;
        sessionManager = new SessionManager(context);
        appSignatureHelper = new AppSignatureHelper(context);
    }

    public User getUser(){
        User user = new User();
        sessionManager.setData(Constant.KEY_USER_SIGNATURE , appSignatureHelper.getAppSignatures().get(0));
        user.setSessionKey(sessionManager.getData(Constant.KEY_USER_SIGNATURE));
         if (sessionManager.getData(Constant.KEY_USER_IDENTITY)!= null){
            user.setIdentity(sessionManager.getData(Constant.KEY_USER_IDENTITY));
        }
        Toast.makeText(context,sessionManager.getData(Constant.KEY_USER_IDENTITY) , Toast.LENGTH_SHORT).show();
        return user;
    }

    public void updateUserIdentity(String identity){
        sessionManager.setData(Constant.KEY_USER_IDENTITY , identity);
    }

    public void clearCacheUser(){
        sessionManager.setData(Constant.KEY_USER_IDENTITY , null);
        sessionManager.setData(Constant.KEY_USER_SIGNATURE , null);
    }

}
