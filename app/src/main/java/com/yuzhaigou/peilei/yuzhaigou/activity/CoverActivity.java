package com.yuzhaigou.peilei.yuzhaigou.activity;

import android.content.Intent;

import com.yuzhaigou.peilei.yuzhaigou.R;
import com.yuzhaigou.peilei.yuzhaigou.base.BaseActivity;

import org.xutils.view.annotation.ContentView;

import java.util.Timer;
import java.util.TimerTask;

@ContentView(R.layout.activity_cover)
public class CoverActivity extends BaseActivity {
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Intent intent = new Intent(CoverActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    public void bindAdapter() {

    }

    @Override
    public void initView() {
        timer.schedule(task,3000);
    }

    @Override
    public void initData() {

    }

}
