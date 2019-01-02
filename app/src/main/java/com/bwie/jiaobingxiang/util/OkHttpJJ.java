package com.bwie.jiaobingxiang.util;

import com.bwie.jiaobingxiang.event.LoggingInterceptor;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpJJ {

    private FormBody formBody;

    //首页数据请求
    public void okGetNotHaveCan(String url, Callback callback){
        //创建okHttp对象
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor())
                .build();
        //获得请求
        Request request = new Request.Builder().url(url).method("GET", null)
                .header("User-Agent","OkHttp Example")
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    //有参  详情页请求
    public void okGetHaveCan(String url,String pid, Callback callback){
        //创建okHttp对象
        OkHttpClient okHttpClient = new OkHttpClient();
        formBody = new FormBody.Builder()
                .add("pid",pid)
                .build();
        //获得请求
        Request request = new Request.Builder().url(url).post(formBody).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
