package com.scut.itpm.umo;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by shu on 2016/12/7.
 */

public class UmoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}
