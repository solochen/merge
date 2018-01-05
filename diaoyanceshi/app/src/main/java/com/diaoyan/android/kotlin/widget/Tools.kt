package com.diaoyan.android.kotlin.widget

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.widget.TextView
import android.widget.Toast
import java.net.URL
import java.util.*

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}



object Tools {


    fun px2dip(context: Context, px: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (px / scale + 0.5f * if (px >= 0) 1 else -1).toInt()
    }

    fun px2sp(context: Context, pxValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

    fun sp2px(context: Context, spValue: Float): Int {

        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,

                spValue, context.resources.displayMetrics).toInt()
    }

    fun dip2px(context: Context, dip: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dip * scale + 0.5f * if (dip >= 0) 1 else -1).toInt()
    }

    fun getScreenH(context: Context): Int {
        return context.resources.displayMetrics.heightPixels;
    }

    fun getAppHeight(act: Activity): Int{
        val outRect = Rect()
        act.window.decorView.getWindowVisibleDisplayFrame(outRect)
        return outRect.height()
    }

}
