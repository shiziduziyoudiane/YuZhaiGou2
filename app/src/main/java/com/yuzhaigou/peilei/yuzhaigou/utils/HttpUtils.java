package com.yuzhaigou.peilei.yuzhaigou.utils;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.yuzhaigou.peilei.yuzhaigou.App;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @describe: 网络请求工具类
 * @package: com.yaomingzi.rookie.utils
 * @author: yaomingzi
 * @data: 2016-02-21 20:24
 */
public class HttpUtils {

    private static Dialog sLoadDialog;//请求Dialog

    private static List<Callback.Cancelable> sCancelables = new ArrayList<>();//请求队列

    /**
     * 网络请求 get
     *
     * @param url      请求Url
     * @param activity activity
     * @param callBack 请求回调接口
     */
    public static void get(String url, Activity activity, final CallBack callBack) {

        //开启或关闭进度条
//        if (isDialog) {
//            sLoadDialog = getLoadingDialog(activity);
//        }
//        if (isDialog) {
//            sLoadDialog.show();
//        }
        //开始请求
        RequestParams params = new RequestParams(url);
        Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (callBack != null) {
                    callBack.onSuccess(result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(App.getInstance(), "网络出错", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
//                if (isDialog && sLoadDialog != null) {
//                    sLoadDialog.dismiss();
//                }

            }
        });
        sCancelables.add(cancelable);
    }
    public static void post(RequestParams params, Activity activity, final CallBack callBack) {

        //开启或关闭进度条
//        if (isDialog) {
//            sLoadDialog = getLoadingDialog(activity);
//        }
//        if (isDialog) {
//            sLoadDialog.show();
//        }
        //开始请求
        Callback.Cancelable cancelable = x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (callBack != null) {
                    callBack.onSuccess(result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(App.getInstance(), "网络出错", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
//                if (isDialog && sLoadDialog != null) {
//                    sLoadDialog.dismiss();
//                }

            }
        });
        sCancelables.add(cancelable);
    }


    /**
     * 显示最后刷新时间
     *
     * @param refreshView pullToRefresh
     */
    public static void showTime(PullToRefreshBase refreshView) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String label = format.format(new Date());
        // 显示最后更新的时间
        refreshView.getLoadingLayoutProxy()
                .setLastUpdatedLabel(label);
    }

    /**
     * 取消请求
     */
    public static void cancelAll() {
        if (sCancelables != null && sCancelables.size() > 0) {
            for (int i = 0, len = sCancelables.size(); i < len; i++) {
                sCancelables.get(i).cancel();
            }
            sCancelables.clear();
        }
    }

    /**
     * 得到自定义的progressDialog
     *
     * @param context Context
     * @return 返回
     */
//    public static Dialog getLoadingDialog(Context context) {
//
//        LayoutInflater inflater = LayoutInflater.from(context);
//        // 加载view
//        View view = inflater.inflate(R.layout.loading_dialog, null);
//        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.rel_loading);
//        // main.xml中的ImageView
//        ImageView spaceshipImage = (ImageView) view.findViewById(R.id.img_loading);
//        // 加载动画
//        Animation animation = AnimationUtils.loadAnimation(
//                context, R.anim.loading_animation);
//        // 使用ImageView显示动画
//        spaceshipImage.startAnimation(animation);
//        // 创建自定义样式dialog
//        Dialog loadingDialog = new Dialog(context, R.style.LoadingDialog);
//        // 可以用“返回键”取消
//        loadingDialog.setCancelable(true);
//        // 设置布局
//        loadingDialog.setContentView(layout, new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.MATCH_PARENT,
//                RelativeLayout.LayoutParams.MATCH_PARENT));
//        return loadingDialog;
//
//    }

    /**
     * 请求回调接口
     */
    public interface CallBack {
        void onSuccess(String result);
    }
}
