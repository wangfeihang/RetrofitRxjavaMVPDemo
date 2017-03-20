package com.sakuramomoko.demo.retrofitrxjavamvpdemo;

import android.app.Application;

/**
 * Created by wangfeihang on 2017/3/20.
 */
public class MyApplication extends Application {

    public static MyApplication APP_CONTEXT;

    @Override
    public void onCreate() {
        APP_CONTEXT = this;
        super.onCreate();
    }
}
