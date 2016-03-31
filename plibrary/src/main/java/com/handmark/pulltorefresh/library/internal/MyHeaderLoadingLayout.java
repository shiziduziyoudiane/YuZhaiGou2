package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.R;

/**
 * Created by Administrator on 2016/3/24.
 */
public class MyHeaderLoadingLayout extends LoadingLayout {
    LayoutInflater inflater;
    AnimationDrawable drawable;
    Animation animation1;
    Animation animation2;
    Animation animation3;
    private TextView headText;
    private ImageView headimage;
    public MyHeaderLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pull_to_refresh_header_vertical,null);
        headText = (TextView) view.findViewById(R.id.pull_to_refresh_text);
        headimage = (ImageView) view.findViewById(R.id.pull_to_refresh_image);
        animation1 = AnimationUtils.loadAnimation(context,R.anim.slide_in_from_top);
        animation2 = AnimationUtils.loadAnimation(context,R.anim.up_down_rotate);
        animation3 = AnimationUtils.loadAnimation(context,R.anim.slide_out_to_top);
    }

    @Override
    protected int getDefaultDrawableResId() {
        return 0;
    }

    @Override
    protected void onLoadingDrawableSet(Drawable imageDrawable) {

    }

    @Override
    protected void onPullImpl(float scaleOfLayout) {

        headimage.setImageResource(R.drawable.pull_to_refresh_arrow_down);
        headimage.startAnimation(animation2);
        headText.setText("下拉刷新");
    }

    @Override
    protected void pullToRefreshImpl() {

    }

    @Override
    protected void refreshingImpl() {
        headimage.startAnimation(animation2);
        headText.setText("松开后刷新");
    }

    @Override
    protected void releaseToRefreshImpl() {
        headimage.setImageResource(R.drawable.rotate_anim);
        drawable = (AnimationDrawable) headimage.getDrawable();
        drawable.start();
    }

    @Override
    protected void resetImpl() {
        headimage.clearAnimation();
    }
}
