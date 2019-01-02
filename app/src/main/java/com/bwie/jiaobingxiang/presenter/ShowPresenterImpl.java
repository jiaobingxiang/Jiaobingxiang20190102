package com.bwie.jiaobingxiang.presenter;

import com.bwie.jiaobingxiang.Api.Api;
import com.bwie.jiaobingxiang.MainActivity;
import com.bwie.jiaobingxiang.model.IShowModel;
import com.bwie.jiaobingxiang.model.ShowModelImpl;

public class ShowPresenterImpl implements IShowPresenter {
    MainActivity mainActivity;
    private final ShowModelImpl showModel;

    public ShowPresenterImpl(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        showModel = new ShowModelImpl();
    }

    @Override
    public void getShow() {
        showModel.getShowData(Api.BASE_HOME, new IShowModel.ShowCallBack() {
            @Override
            public void showSuccess(String data) {
                mainActivity.getShowView(data);
            }

            @Override
            public void showFail() {
                mainActivity.getShowView("请求失败");
            }
        });
    }
}
