package com.yuzhaigou.peilei.yuzhaigou.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/3/24.
 */
public abstract class MyListAdapter<T> extends BaseAdapter {

    public LayoutInflater inflater;
    public List<T> mData;

    public MyListAdapter(List<T>data, Context context){
        mData = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position,convertView,parent);
    }

    public abstract View getItemView(int position, View convertView, ViewGroup parent);


}
