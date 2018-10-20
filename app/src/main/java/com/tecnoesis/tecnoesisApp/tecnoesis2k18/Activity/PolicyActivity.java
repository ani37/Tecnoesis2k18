package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;

public class PolicyActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        webView = findViewById(R.id.wv_privacy);
        webView.loadUrl("http://tecnoesis.in/privacy/privacy.html");


    }
}
