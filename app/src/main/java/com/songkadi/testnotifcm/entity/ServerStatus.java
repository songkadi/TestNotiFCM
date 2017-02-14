package com.songkadi.testnotifcm.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServerStatus {
    @SerializedName("startTime")
    @Expose
    private String startTime;

    @SerializedName("uptime")
    @Expose
    private String uptime;

    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    @SerializedName("serverName")
    @Expose
    private String serverName;

    @SerializedName("serverPort")
    @Expose
    private String serverPort;

    @SerializedName("memory")
    @Expose
    private StatusAmount memory;

    @SerializedName("thread")
    @Expose
    private StatusAmount thread;

    public ServerStatus() {
    }

    public ServerStatus(String startTime, String uptime, String timestamp, String serverName, String serverPort, StatusAmount memory,
                        StatusAmount thread) {
        this.startTime = startTime;
        this.uptime = uptime;
        this.timestamp = timestamp;
        this.serverName = serverName;
        this.serverPort = serverPort;
        this.memory = memory;
        this.thread = thread;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public StatusAmount getMemory() {
        return memory;
    }

    public void setMemory(StatusAmount memory) {
        this.memory = memory;
    }

    public StatusAmount getThread() {
        return thread;
    }

    public void setThread(StatusAmount thread) {
        this.thread = thread;
    }

}