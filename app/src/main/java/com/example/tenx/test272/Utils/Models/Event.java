package com.example.tenx.test272.Utils.Models;

public class Event {
    private int mImgRes;
    private String mUrl;
    private String mDesc;

    public Event(int mImgRes, String mUrl, String mDesc) {
        this.mImgRes = mImgRes;
        this.mUrl = mUrl;
        this.mDesc = mDesc;
    }

    public int getmImgRes() {
        return mImgRes;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmDesc() {
        return mDesc;
    }
}
