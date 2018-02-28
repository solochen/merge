package com.diaoyan.android.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.diaoyan.android.R;

/**
 * Created by chenshaolong on 2018/2/27.
 */

public class DefineView extends TextView{

    private int backgroundSecondColor;

    public DefineView(Context context) {
        super(context);
    }

    public DefineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs){
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DefineViewDemo);
        backgroundSecondColor = a.getColor(R.styleable.DefineViewDemo_background_second_color, Color.parseColor("#ff2d55"));
        a.recycle();
    }



//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(200, 200);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.RED);
        int r = getMeasuredWidth() / 2;
        int centerX = getLeft() + r;
        int centerY = getTop() + r;


        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawCircle(50, 50, 50, paint);

    }
}
