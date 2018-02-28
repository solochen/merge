package com.diaoyan.android.ui.activity.videolist.ui;

import android.os.Bundle;

import com.diaoyan.android.R;
import com.diaoyan.android.base.BaseActivity;

/**
 * Created by chenshaolong on 2017/11/9.
 */

public class VideoMutilActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_container, new RecyclerViewFragment(), "RecyclerViewFragment")
                .addToBackStack(null)
                .commit();

    }
}
