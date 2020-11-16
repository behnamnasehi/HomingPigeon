package com.behnamnasehi.supportconnection.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HandShake {

    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private Data data;

    @SerializedName("api_key")
    @Expose
    private String apiKey;

    @SerializedName("package_name")
    @Expose
    private String packageName;

    @SerializedName("identity")
    @Expose
    private String identity;

    @SerializedName("session_key")
    @Expose
    private String sessionKey;

    @SerializedName("device_model")
    @Expose
    private String deviceModel;

    public HandShake(String apiKey, String sessionKey, String packageName, String deviceModel) {
        this.apiKey = apiKey;
        this.sessionKey = sessionKey;
        this.packageName = packageName;
        this.deviceModel = deviceModel;

    }

    public HandShake(String apiKey, String sessionKey, String identity, String packageName, String deviceModel) {
        this.apiKey = apiKey;
        this.identity = identity;
        this.packageName = packageName;
        this.sessionKey = sessionKey;
        this.deviceModel = deviceModel;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
