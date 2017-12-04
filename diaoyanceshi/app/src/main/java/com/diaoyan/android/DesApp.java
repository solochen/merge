package com.diaoyan.android;

import android.app.Application;
import com.diaoyan.android.crashoptimizition.CrashActivity;
import cat.ereza.customactivityoncrash.config.CaocConfig;

/**
 * Created by chenshaolong on 2017/11/5.
 */

public class DesApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String jjj = "";
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //default: CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM
                .enabled(true) //default: true
                .showErrorDetails(true) //default: true
                .showRestartButton(false) //default: true
                .trackActivities(true) //default: false
                .minTimeBetweenCrashesMs(2000) //default: 3000
                .restartActivity(MainActivity.class) //default: null (your app's launch activity)
                .errorActivity(CrashActivity.class) //default: null (default error activity)
                .eventListener(null) //default: null
                .apply();
    }
}
