package com.yuzhaigou.peilei.yuzhaigou.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yuzhaigou.peilei.yuzhaigou.Constance.UrlConstance;
import com.yuzhaigou.peilei.yuzhaigou.R;
import com.yuzhaigou.peilei.yuzhaigou.base.BaseFragment;
import com.yuzhaigou.peilei.yuzhaigou.bean.AdvList;
import com.yuzhaigou.peilei.yuzhaigou.bean.Entity;
import com.yuzhaigou.peilei.yuzhaigou.utils.HttpUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/23.
 */
@ContentView(R.layout.fragment_first)
public class FirstFragment extends BaseFragment {
    @ViewInject(R.id.lv_first_fragment)
    private PullToRefreshListView ptrlv;
    private ConvenientBanner convenientBanner;
//    private PullToRefreshExpandableListView refreshableView;
        private ListView lv;
//    private ExpandableListView mExpandListView;
    private FirstFragmentListAdapter adapter;

    private List<String> test = new ArrayList<>();
    private List<AdvList> bannerData = new ArrayList<>();
    private View view;

//    private LayoutInflater inflater = LayoutInflater.from(getActivity());

    public static Fragment newInstance() {
        FirstFragment firstFragment = new FirstFragment();
        return firstFragment;
    }

    @Override
    protected void bindAdapter() {

    }

    @Override
    protected void initView() {
        ptrlv.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        adapter = new FirstFragmentListAdapter(test, getActivity());
        lv = ptrlv.getRefreshableView();
        view = LayoutInflater.from(getActivity()).inflate(R.layout.first_headview,null);
        lv.addHeaderView(view);
        lv.setAdapter(adapter);
//        ptrlv.onRefreshComplete();
        ptrlv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                refreshView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }

    private void initBanner() {
        convenientBanner = new ConvenientBanner(getActivity());
        convenientBanner = (ConvenientBanner) view.findViewById(R.id.banner_first_head);
        convenientBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        },bannerData).setPageIndicator(new int[]{R.mipmap.dot_normal,R.mipmap.dot_selected});
        convenientBanner.startTurning(5000);
    }

    @Override
    protected void initData() {
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
        RequestParams params = new RequestParams(UrlConstance.url_post_firstBanner);
        params.addBodyParameter("apKey","topbanner");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Entity entity = JSONObject.parseObject(result,Entity.class);
                bannerData = entity.getData().get(0).getAdvList();
                initBanner();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
//                Toast.makeText(App.getInstance(), "网络出错", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        }
        );
        getHttpData();
    }

    private void getHttpData() {
        HttpUtils.get(UrlConstance.url_get_firstRecycle, getActivity(), new HttpUtils.CallBack() {
            @Override
            public void onSuccess(String result) {

            }
        });
    }

    private class LocalImageHolderView implements Holder<AdvList>{
    private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context,final int position, AdvList data) {
            x.image().bind(imageView, UrlConstance.url_basic+data.getResUrl());
        }
    }
    // 开始自动翻页


    // 停止自动翻页

    @Override

    public void onPause() {

        super.onPause();

        //停止翻页

        convenientBanner.stopTurning();

    }

}
