package com.diaoyan.android.dragview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.diaoyan.android.R;
import com.diaoyan.android.widget.DragCustomView;

import static com.diaoyan.android.dragview.LivePlayerHelper.getRTCWindowView;
import static com.diaoyan.android.dragview.LivePlayerHelper.removeRTCView;
import static com.diaoyan.android.dragview.LivePlayerHelper.FIRST_TAG;
import static com.diaoyan.android.dragview.LivePlayerHelper.SECOND_TAG;
import static com.diaoyan.android.dragview.LivePlayerHelper.THIRD_TAG;

/**
 * Created by chenshaolong on 2017/12/7.
 */

public class DragActivity extends Activity {

    DragCustomView mParentView;

    Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
        mContext = this;
        mParentView = (DragCustomView) findViewById(R.id.container_view);
    }


    public void onBtnClick(View view){
        switch (view.getId()) {
            case R.id.btn_add_one:
                mParentView.addView(getRTCWindowView(mContext, R.color.cardview_dark_background, FIRST_TAG));
                break;
            case R.id.btn_add_two:

                mParentView.addView(getRTCWindowView(mContext, R.color.key_ok_color, SECOND_TAG));

                break;
            case R.id.btn_add_third:

                mParentView.addView(getRTCWindowView(mContext, R.color.colorAccent, THIRD_TAG));

                break;
            case R.id.btn_remove_first:
                removeRTCView(mParentView, FIRST_TAG);
                break;
            case R.id.btn_remove_second:
                removeRTCView(mParentView, SECOND_TAG);
                break;
            case R.id.btn_remove_third:
                removeRTCView(mParentView, THIRD_TAG);
                break;
            case R.id.btn_reset:
                LivePlayerHelper.resetView(mParentView);
                break;
        }
    }
}
