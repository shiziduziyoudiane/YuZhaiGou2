package com.yuzhaigou.peilei.yuzhaigou;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/3/22.
 */
public class App extends Application {
    private static App mApp;
    public  static App getInstance() {
        return mApp;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
