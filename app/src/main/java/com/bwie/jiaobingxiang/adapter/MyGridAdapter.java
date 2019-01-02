package com.bwie.jiaobingxiang.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.jiaobingxiang.R;
import com.bwie.jiaobingxiang.bean.ShowBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class MyGridAdapter extends BaseAdapter {
    List<ShowBean.DataBean.MiaoshaBean.ListBean> list;
    Context context;

    public MyGridAdapter(List<ShowBean.DataBean.MiaoshaBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.grid_item, null);
            viewHolder.imageView = convertView.findViewById(R.id.grid_image);
            viewHolder.textView1 = convertView.findViewById(R.id.grid_title);
            viewHolder.textView2 = convertView.findViewById(R.id.grid_price);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView1.setText(list.get(position).getTitle());
        viewHolder.textView2.setText("￥" + list.get(position).getPrice());
        ImageLoader.getInstance().displayImage("https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg", viewHolder.imageView);
        return convertView;
    }

    class ViewHolder {
        TextView textView1, textView2;
        ImageView imageView;
    }
}
