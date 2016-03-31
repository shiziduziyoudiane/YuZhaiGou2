package com.yuzhaigou.peilei.yuzhaigou.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

/**
 * Created by Angel on 2016/3/7.
 */
public class FragmentUtils implements RadioGroup.OnCheckedChangeListener {

    private List<Fragment> fragments; // 一个tab页面对应一个Fragment

    private RadioGroup rgs; // 用于切换tab

    private FragmentManager fragmentManager; // Fragment所属的Activity

    private int fragmentContentId; // Activity中所要被替换的区域的id

    private int currentTab; // 当前Tab页面索引

    private OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener; // 用于让调用者在切换tab时候增加新的功能

   // private SlidingMenu slidingmenu;


    public FragmentUtils(FragmentManager fragmentManager, List<Fragment> fragments, int fragmentContentId, RadioGroup rgs, OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener) {
        this.fragments = fragments;
        this.rgs = rgs;
        this.fragmentManager = fragmentManager;
        this.fragmentContentId = fragmentContentId;
    //    this.slidingmenu =slidingMenu;
        this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener;
        rgs.setOnCheckedChangeListener(this);
        ((RadioButton) rgs.getChildAt(0)).setChecked(true);
    }

    public FragmentUtils(FragmentManager supportFragmentManager, List<Fragment> fragments, int container_main, RadioGroup rdg) {
        this(supportFragmentManager, fragments, container_main, rdg, null);
    }

//
//    public FragmentUtils(FragmentManager fragmentManager, List<Fragment> fragments, int fragmentContentId, RadioGroup rgs,SlidingMenu slidingMenu) {
//        this(fragmentManager, fragments, fragmentCo
// ntentId, rgs, slidingMenu,null);
//    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        for (int i = 0; i < rgs.getChildCount(); i++) {
            RadioButton button = (RadioButton) rgs.getChildAt(i);
            if (button.getId() == checkedId) {
           //     button.setTextColor(Color.RED);
                Fragment fragment = fragments.get(i);

                FragmentTransaction ft = obtainFragmentTransaction(i);

                getCurrentFragment().onStop();

                if (fragment.isAdded()) {

                    fragment.onStart();

                } else {

                    ft.add(fragmentContentId, fragment);

                    ft.commit();
                }

                showTab(i);

         //       slidingmenu.showContent();

                if (null != onRgsExtraCheckedChangedListener) {

                    onRgsExtraCheckedChangedListener.OnRgsExtraCheckedChanged(radioGroup, checkedId, i);

                }

            }else{
              //  button.setTextColor(Color.GRAY);
            }
        }

    }


    private void showTab(int idx) {

        for (int i = 0; i < fragments.size(); i++) {

            Fragment fragment = fragments.get(i);

            FragmentTransaction ft = obtainFragmentTransaction(idx);

            if (idx == i) {

                ft.show(fragment);

            } else {

                ft.hide(fragment);

            }

            ft.commit();

        }
        currentTab = idx;
    }


    private FragmentTransaction obtainFragmentTransaction(int index) {

        FragmentTransaction ft = fragmentManager.beginTransaction();

        return ft;
    }


    public int getCurrentTab() {
        return currentTab;
    }


    public Fragment getCurrentFragment() {
        return fragments.get(currentTab);
    }


    public OnRgsExtraCheckedChangedListener getOnRgsExtraCheckedChangedListener() {
        return onRgsExtraCheckedChangedListener;
    }


    public void setOnRgsExtraCheckedChangedListener(OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener) {
        this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener;
    }


    public static interface OnRgsExtraCheckedChangedListener {
        public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index);
    }

}
