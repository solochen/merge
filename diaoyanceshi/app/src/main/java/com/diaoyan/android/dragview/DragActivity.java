package com.diaoyan.android.dragview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.diaoyan.android.R;

/**
 * Created by chenshaolong on 2017/12/7.
 */

public class DragActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
    }
}
