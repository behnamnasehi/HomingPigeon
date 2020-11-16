package com.behnamnasehi.supportconnection.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User  {

    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("identity")
    @Expose
    private String identity;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("session_key")
    @Expose
    private String sessionKey;

    @SerializedName("user_agent")
    @Expose
    private String userAgent;

    @SerializedName("ip_address")
    @Expose
    private String ipAddress;

    @SerializedName("blocked")
    @Expose
    private boolean blocked;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("project")
    @Expose
    private String project;

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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
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
