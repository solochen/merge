package com.diaoyan.android.utils;

import android.app.Activity;

import com.jude.swipbackhelper.SwipeBackHelper;

/**
 * Created by chenshaolong on 2018/2/26.
 */

public class WindowUtil {


    /**
     * 禁用侧滑退出
     * @param activity
     */
    public static void disableSwipeBack(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            SwipeBackHelper.getCurrentPage(activity).setSwipeBackEnable(false);
            SwipeBackHelper.getCurrentPage(activity).setDisallowInterceptTouchEvent(true);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启用侧滑退出
     * @param activity
     */
    public static void enableSwipeBack(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            SwipeBackHelper.getCurrentPage(activity).setSwipeBackEnable(true);
            SwipeBackHelper.getCurrentPage(activity).setDisallowInterceptTouchEvent(false);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

}
