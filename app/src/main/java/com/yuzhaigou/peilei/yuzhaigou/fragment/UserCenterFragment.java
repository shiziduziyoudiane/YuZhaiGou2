package com.yuzhaigou.peilei.yuzhaigou.fragment;

import android.support.v4.app.Fragment;

import com.yuzhaigou.peilei.yuzhaigou.R;
import com.yuzhaigou.peilei.yuzhaigou.base.BaseFragment;

import org.xutils.view.annotation.ContentView;

/**
 * Created by Administrator on 2016/3/23.
 */
@ContentView(R.layout.fragment_usercenter)
public class UserCenterFragment extends BaseFragment {
    public static Fragment newInstance(){
        UserCenterFragment fragment = new UserCenterFragment();
        return fragment;
    }
    @Override
    protected void bindAdapter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
