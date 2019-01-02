package com.bwie.jiaobingxiang.event;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //chain方法  包含了  request 和 response
        Request request = chain.request();
        long t1 = System.nanoTime();
        Log.i("发送请求", "intercept: "+request.url()+chain.connection()+request.headers());
        Response response = chain.proceed(request);
        //第二次相应时间
        long t2 = System.nanoTime();
        ResponseBody responseBody = response.peekBody(1024 * 1024);
        Log.i("接受响应", "intercept: "+response.request().url()+responseBody.string()+(t2-t1)/1e6d+response.headers());

        return response;
    }
}
