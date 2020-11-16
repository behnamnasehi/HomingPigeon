package com.behnamnasehi.supportconnection.utilitis;

import android.content.Context;
import android.content.Intent;

import com.behnamnasehi.supportconnection.model.HandShake;
import com.google.gson.Gson;

public class Functions {
    private static Gson gson = new Gson();

    public static String convertObjectToString(Object model) {
        return gson.toJson(model);
    }

    public static String getApiKeyPattern(Context context, HandShake handShake) {
        return gson.toJson(handShake);
    }

    public static String getDataFromIntent(Intent intent , String extra){
         return intent.getStringExtra(extra);
    }

}
