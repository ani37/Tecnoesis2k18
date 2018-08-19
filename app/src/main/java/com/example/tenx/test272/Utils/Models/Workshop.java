package com.example.tenx.test272.Utils.Models;

public class Workshop {

    private String mSummary;
    private String mRegUrl;
    private int imgRes;

    public Workshop(String mSummary, String mRegUrl, int imgRes) {
        this.mSummary = mSummary;
        this.mRegUrl = mRegUrl;
        this.imgRes = imgRes;
    }

    public String getmSummary() {
        return mSummary;
    }

    public String getmRegUrl() {
        return mRegUrl;
    }

    public int getImgRes() {
        return imgRes;
    }
}
