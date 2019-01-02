package com.bwie.jiaobingxiang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwie.jiaobingxiang.base.BaseActivity;

public class WebActivity extends BaseActivity {


    private WebView webView;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_web;
    }
}
