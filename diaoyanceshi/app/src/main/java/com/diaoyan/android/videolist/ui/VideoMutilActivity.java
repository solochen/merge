package com.diaoyan.android.videolist.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.diaoyan.android.R;

/**
 * Created by chenshaolong on 2017/11/9.
 */

public class VideoMutilActivity extends AppCompatActivity {

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
