package com.bwie.jiaobingxiang.model;

import com.bwie.jiaobingxiang.util.OkHttpJJ;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ShowModelImpl implements IShowModel {

    @Override
    public void getShowData(String url, final ShowCallBack showCallBack) {
        new OkHttpJJ().okGetNotHaveCan(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                showCallBack.showFail();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                showCallBack.showSuccess(response.body().string());
            }
        });
    }
}
