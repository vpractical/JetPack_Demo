package com.y.jetpack_demo;

import android.app.Application;

import com.y.jetpack_demo.util.AppUtil;

public class JetPackApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtil.init(this);
    }
}
