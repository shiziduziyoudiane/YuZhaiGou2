package com.yuzhaigou.peilei.yuzhaigou.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.xutils.x;

/**
 * Created by Administrator on 2016/3/22.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initData();
        initView();
        bindAdapter();
    }

    public abstract void bindAdapter();



    public abstract void initView() ;



    public abstract void initData() ;


}
