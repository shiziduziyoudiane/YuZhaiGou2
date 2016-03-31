package com.yuzhaigou.peilei.yuzhaigou.activity;

import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yuzhaigou.peilei.yuzhaigou.R;
import com.yuzhaigou.peilei.yuzhaigou.base.BaseActivity;
import com.yuzhaigou.peilei.yuzhaigou.fragment.ClassifyFragment;
import com.yuzhaigou.peilei.yuzhaigou.fragment.FirstFragment;
import com.yuzhaigou.peilei.yuzhaigou.fragment.ShoppingCarFragment;
import com.yuzhaigou.peilei.yuzhaigou.fragment.UserCenterFragment;
import com.yuzhaigou.peilei.yuzhaigou.utils.FragmentUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @ViewInject(R.id.rgs_main_menu)
    private RadioGroup rdg;
    private long mExitTime;
    private List<Fragment>fragments = new ArrayList<>();

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Object mHelperUtils;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void bindAdapter() {

    }

    @Override
    public void initView() {
        fragments.add(FirstFragment.newInstance());
        fragments.add(ClassifyFragment.newInstance());
        fragments.add(ShoppingCarFragment.newInstance());
        fragments.add(UserCenterFragment.newInstance());
        new FragmentUtils(getSupportFragmentManager(),fragments, R.id.container_main,rdg);
    }

    @Override
    public void initData() {

    }
}
