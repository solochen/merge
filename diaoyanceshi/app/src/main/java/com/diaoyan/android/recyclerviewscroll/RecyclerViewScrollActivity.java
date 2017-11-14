package com.diaoyan.android.recyclerviewscroll;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.diaoyan.android.R;

/**
 * Created by chenshaolong on 2017/11/3.
 */

public class RecyclerViewScrollActivity extends AppCompatActivity {

    RecyclerView mRvMain;
    TextView mTvTop;
    TextView mTvBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_scroll);
        mRvMain = (RecyclerView) findViewById(R.id.rv_main);
        mTvTop = (TextView) findViewById(R.id.tv_top);
        mTvBottom = (TextView) findViewById(R.id.tv_bottom);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(RecyclerViewScrollActivity.this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvMain.setLayoutManager(mLayoutManager);
        mRvMain.setAdapter(new ScrollAdapter());
        mRvMain.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                Resources resources = RecyclerViewScrollActivity.this.getResources();
                DisplayMetrics dm = resources.getDisplayMetrics();
                int height = dm.heightPixels;
                mTvBottom.animate()
                        .translationY(height - mTvBottom.getHeight())
                        .setInterpolator(new AccelerateInterpolator(2))
                        .setDuration(800)
                        .start();
                mTvTop.animate()
                        .translationY(-height)
                        .setDuration(800)
                        .setInterpolator(new AccelerateInterpolator(2))
                        .start();
            }

            @Override
            public void onShow() {
                mTvBottom.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).setDuration(800).start();
                mTvTop.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).setDuration(800).start();
            }
        });
    }
}