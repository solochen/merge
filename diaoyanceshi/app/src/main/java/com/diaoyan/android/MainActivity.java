package com.diaoyan.android;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRvMain;
    TextView mTvTop;
    TextView mTvBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRvMain = (RecyclerView) findViewById(R.id.rv_main);
        mTvTop = (TextView) findViewById(R.id.tv_top);
        mTvBottom = (TextView) findViewById(R.id.tv_bottom);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvMain.setLayoutManager(mLayoutManager);
        mRvMain.setAdapter(new ScrollAdapter());
        mRvMain.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                Resources resources = MainActivity.this.getResources();
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
