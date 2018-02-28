package com.diaoyan.android.ui.activity.crashoptimizition;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.diaoyan.android.ui.activity.MainActivity;
import com.diaoyan.android.R;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.config.CaocConfig;

/**
 *
 * 使用 CustomActivityOnCrash 库
 * 让系统crash弹窗-->优雅的crash页面
 * Created by chenshaolong on 2017/11/5.
 */

public class CrashActivity extends AppCompatActivity {

    CaocConfig config;//配置对象

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
        String stackString = CustomActivityOnCrash.getStackTraceFromIntent(getIntent());//将堆栈跟踪作为字符串获取。
        String logString = CustomActivityOnCrash.getActivityLogFromIntent(getIntent()); //获取错误报告的Log信息
        String allString = CustomActivityOnCrash.getAllErrorDetailsFromIntent(this, getIntent());// 获取所有的信息
        config = CustomActivityOnCrash.getConfigFromIntent(getIntent());//获得配置信息,比如设置的程序崩溃显示的页面和重新启动显示的页面等等信息

        ((TextView) findViewById(R.id.tv_crash_detail)).setText(allString);
    }

    public void onBtnClick(View view){
        switch (view.getId()){
            case R.id.btn_restart:
                startActivity(new Intent(CrashActivity.this, MainActivity.class));
                break;
            case R.id.btn_close:
                finish();
                break;

//            case R.id.btn_restart:
//                new Intent(CrashActivity.this, MainActivity.class);
////                CustomActivityOnCrash.restartApplicationWithIntent(CrashActivity.this, new Intent(CrashActivity.this, MainActivity.class), config);
//                break;
//            case R.id.btn_close:
////                CustomActivityOnCrash.closeApplication(CrashActivity.this, config);
//                finish();
//                break;
        }
    }
}
