package com.bwie.jiaobingxiang.model;

public interface IShowModel {
    void getShowData(String url,ShowCallBack showCallBack);
     public interface ShowCallBack{
         void showSuccess(String data);
         void showFail();
    }
}
