package com.lh.mywidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;

/**
 * Created by Liaohuan on 2016/12/26.
 *
 * @说明 之所以在Provider内直接使用handler控制循环，因为在Provider里面更加稳定。
 * 使用service的话service可能会被回收，导致不能循环更新。
 */
public class MyWidgetProvider extends AppWidgetProvider {
    private static final String TAG = "MyWidgetProvider";
    private static Context mContext;
    private static final String url = "https://api.thinkpage.cn/v3/weather/now" +
            ".json?key=qyrggzdvkn9pnga3&location=ip";
    private static final int WeatherRefresh = 1000 * 60 * 30;
    private static RemoteViews mRemoteViews;

    private static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(mContext, "err" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "onError: " + e.getMessage(), e);
                        mRemoteViews.setTextViewText(R.id.tv_weather, "获取失败");
                        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(mContext);
                        appWidgetManager.updateAppWidget(new ComponentName(mContext,
                                MyWidgetProvider.class), mRemoteViews);

                        mHandler.sendEmptyMessageDelayed(0, WeatherRefresh);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        DataBean dataBean = (DataBean) DataFactory.getInstanceByJson(DataBean
                                .class, response);
                        String weather = "";
                        DataBean.Results results = dataBean.getResults().get(0);
                        String t=results.getLast_update().substring(11,16);
                        weather = results.getLocation().getName() + ":" + results.getNow()
                                .getText() +
                                " " + results.getNow().getTemperature() + "℃"+"("+t+")";
                        Toast.makeText(mContext, weather, Toast.LENGTH_SHORT).show();
                        mRemoteViews.setTextViewText(R.id.tv_weather, weather);
                        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(mContext);
                        appWidgetManager.updateAppWidget(new ComponentName(mContext,
                                MyWidgetProvider.class), mRemoteViews);
                        mHandler.sendEmptyMessageDelayed(0, WeatherRefresh);
                    }
                });
            }
            if (msg.what == 1) {
                Log.i(TAG, "handleMessage: time refresh ones");
                Object o[] = MyWidgetProvider.getTimeAndSecond();
                mRemoteViews.setTextViewText(R.id.tv_time, (String) o[0]);
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(mContext);
                appWidgetManager.updateAppWidget(new ComponentName(mContext,
                        MyWidgetProvider.class), mRemoteViews);
                mHandler.sendEmptyMessageDelayed(1, (int) o[1]);
            }

        }
    };

    @Override
    public void onEnabled(Context context) {
        Log.d(TAG, "onEnabled: ");
        mContext = context;
        mRemoteViews = new RemoteViews(context.getPackageName(), R.layout.layout_appwidget);
        mHandler.sendEmptyMessage(0);
        mHandler.sendEmptyMessage(1);
        super.onEnabled(context);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG, "onUpdate: ");
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.d(TAG, "onDeleted: ");
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) {
        Log.d(TAG, "onDisabled: ");
        mHandler.removeMessages(0);
        mHandler.removeMessages(1);
        super.onDisabled(context);
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int
            appWidgetId, Bundle newOptions) {
        Log.d(TAG, "onAppWidgetOptionsChanged: ");
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: ");

        super.onReceive(context, intent);
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        Log.d(TAG, "onRestored: ");
        super.onRestored(context, oldWidgetIds, newWidgetIds);
    }

    /**
     * @返回 一个长度为2的object对象数组 第一个值为String 类型的tiem，第二个为int类型的second
     */
    public static Object[] getTimeAndSecond() {
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");
        SimpleDateFormat second = new SimpleDateFormat("ss");
        Date date = new Date(System.currentTimeMillis());
        String times = time.format(date);
        String seconds = second.format(date);
        int countSecond = 60 - Integer.valueOf(seconds);
        Object t[] = new Object[2];
        t[0] = times;
        t[1] = countSecond * 1000;
        return t;
    }

}
