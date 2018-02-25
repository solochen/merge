package com.diaoyan.android;

import android.app.Application;

/**
 * Created by chenshaolong on 2017/11/5.
 */

public class DesApp extends Application {

    public static DesApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
