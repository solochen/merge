package com.diaoyan.android.ui.activity.dragview;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by chenshaolong on 2017/12/14.
 */

public class LivePlayerHelper {

    public static final String FIRST_TAG = "1001";
    public static final String SECOND_TAG = "1002";
    public static final String THIRD_TAG = "1003";

    public static RelativeLayout getRTCWindowView(Context context, int color, String tag){
        RelativeLayout subView = new RelativeLayout(context);
        RelativeLayout.LayoutParams subViewParams = new RelativeLayout.LayoutParams(
                250, 400);

        subViewParams.topMargin = 10;
        subViewParams.rightMargin = 10;
        subView.setBackgroundColor(context.getResources().getColor(color));
        subView.setLayoutParams(subViewParams);
        subView.setTag(tag);
        return subView;
    }

    public static void resetView(LinearLayout containerView){
        for(int i = 0; i < containerView.getChildCount(); i ++){
            RelativeLayout view = (RelativeLayout) containerView.getChildAt(i);
            view.setLayoutParams(view.getLayoutParams());
        }
    }

    public static void removeRTCView(LinearLayout rtcContainer, String targetTag) {
        for (int i = 0; i < rtcContainer.getChildCount(); i++) {
            View childView = rtcContainer.getChildAt(i);
            String viewTag = String.valueOf(childView.getTag());
            if (targetTag == viewTag) {
                rtcContainer.removeViewAt(i);
                return;
            }
        }
    }

}
