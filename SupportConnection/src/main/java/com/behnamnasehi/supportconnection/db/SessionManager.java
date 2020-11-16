package com.behnamnasehi.supportconnection.db;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.google.gson.Gson;

public class SessionManager {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
        editor.apply();
    }

    public String getData(String key) {
        return pref.getString(key, null);
    }

    public void setData(String key,String value) {
        editor.putString(key, value);
        editor.apply();
        editor.commit();
    }

}
