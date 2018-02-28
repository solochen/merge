package com.diaoyan.android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.jude.swipbackhelper.SwipeBackHelper;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by chenshaolong on 2018/2/26.
 */

public class BaseActivity extends FragmentActivity {

    protected CompositeDisposable mDisposables = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSwipeBack();

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }

    private void initSwipeBack() {
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(true)
                .setSwipeSensitivity(0.5f)
                .setSwipeRelateEnable(true)
                .setSwipeRelateOffset(300);
    }

}
