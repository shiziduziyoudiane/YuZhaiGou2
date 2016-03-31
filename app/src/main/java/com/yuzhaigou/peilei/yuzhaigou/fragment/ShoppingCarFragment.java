package com.yuzhaigou.peilei.yuzhaigou.fragment;

import android.support.v4.app.Fragment;

import com.yuzhaigou.peilei.yuzhaigou.R;
import com.yuzhaigou.peilei.yuzhaigou.base.BaseFragment;

import org.xutils.view.annotation.ContentView;

/**
 * Created by Administrator on 2016/3/23.
 */
@ContentView(R.layout.fragment_shoppingcar)
public class ShoppingCarFragment extends BaseFragment {
    public static Fragment newInstance(){
        ShoppingCarFragment fragment = new ShoppingCarFragment();
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
