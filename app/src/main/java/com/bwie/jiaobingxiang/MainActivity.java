package com.bwie.jiaobingxiang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.bwie.jiaobingxiang.adapter.MyGridAdapter;
import com.bwie.jiaobingxiang.base.BaseActivity;
import com.bwie.jiaobingxiang.bean.ShowBean;
import com.bwie.jiaobingxiang.presenter.ShowPresenterImpl;
import com.bwie.jiaobingxiang.view.IShowView;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity implements IShowView {


    private GridView gv;
    private List<ShowBean.DataBean.MiaoshaBean.ListBean> list;
    private MyGridAdapter myGridAdapter;

    @Override
    protected void initListener() {
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String detailUrl = list.get(position).getDetailUrl();
                Intent intent = new Intent(MainActivity.this,WebActivity.class);
                intent.putExtra("url",detailUrl);
                startActivity(intent);
            }
        });
        gv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                myGridAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        gv = findViewById(R.id.gv);
        ShowPresenterImpl showPresenter = new ShowPresenterImpl(MainActivity.this);
        showPresenter.getShow();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void getShowView(final String data) {
        Log.i("123", "getShowView: "+data);
        new Thread(){
            @Override
            public void run() {
                super.run();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        ShowBean showBean = gson.fromJson(data, ShowBean.class);
                        list = showBean.getData().getMiaosha().getList();
                        myGridAdapter = new MyGridAdapter(list, MainActivity.this);
                        gv.setAdapter(myGridAdapter);
                    }
                });
            }
        }.start();
    }
}
