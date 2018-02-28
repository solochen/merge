package com.diaoyan.android.ui.activity.crashoptimizition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.diaoyan.android.R;
import com.diaoyan.android.base.BaseActivity;

/**
 * Created by chenshaolong on 2017/11/5.
 */

public class OptimizationActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimization);
    }

    public void onBtnClick(View v){
        switch (v.getId()) {
            case R.id.btn_crash:
                throw new RuntimeException("Boom!");
        }
    }
}
