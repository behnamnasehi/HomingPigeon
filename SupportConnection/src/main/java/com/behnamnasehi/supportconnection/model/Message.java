package com.behnamnasehi.supportconnection.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Message  {

    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("index")
    @Expose
    private String index;

    @SerializedName("from")
    @Expose
    private String from;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("event")
    @Expose
    private int event;

    @SerializedName("user_agent")
    @Expose
    private String user_agent;

    @SerializedName("read_status")
    @Expose
    private int readStatus;

    @SerializedName("updated_at")
    @Expose
    private long updatedAt;

    @SerializedName("created_at")
    @Expose
    private long createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public void setUser_agent(String user_agent) {
        this.user_agent = user_agent;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
