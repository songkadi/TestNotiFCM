package com.songkadi.testnotifcm.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusAmount {
    @SerializedName("max")
    @Expose
    private long max;

    @SerializedName("free")
    @Expose
    private long free;

    @SerializedName("used")
    @Expose
    private long used;

    @SerializedName("freeP")
    @Expose
    private long freeP;

    @SerializedName("usedP")
    @Expose
    private long usedP;

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public long getFree() {
        return free;
    }

    public void setFree(long free) {
        this.free = free;
    }

    public long getUsed() {
        return used;
    }

    public void setUsed(long used) {
        this.used = used;
    }

    public long getFreeP() {
        return freeP;
    }

    public void setFreeP(long freeP) {
        this.freeP = freeP;
    }

    public long getUsedP() {
        return usedP;
    }

    public void setUsedP(long usedP) {
        this.usedP = usedP;
    }

}
