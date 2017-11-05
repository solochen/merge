package com.diaoyan.android.crashoptimizition;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.diaoyan.android.R;

/**
 * Created by chenshaolong on 2017/11/5.
 */

public class OptimizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimization);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Boom!");
            }
        }, 10000);
    }

    public void onBtnClick(View v){
        switch (v.getId()) {
            case R.id.btn_crash:
                throw new RuntimeException("Boom!");
        }
    }
}
