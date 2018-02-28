package com.diaoyan.android.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.diaoyan.android.R;
import com.diaoyan.android.base.BaseActivity;
import com.diaoyan.android.model.bean.UserBean;
import com.diaoyan.android.model.net.reset.LoginRest;
import com.diaoyan.android.ui.activity.crashoptimizition.OptimizationActivity;
import com.diaoyan.android.ui.dialog.ShareDialogFragment;
import com.diaoyan.android.ui.activity.dragview.DragActivity;
import com.diaoyan.android.ui.activity.keyboard.XianYuActivity;
import com.diaoyan.android.ui.activity.recyclerviewscroll.RecyclerViewScrollActivity;
import com.diaoyan.android.ui.activity.reflection.ReflectionActivity;
import com.diaoyan.android.utils.WindowUtil;
import com.diaoyan.android.ui.activity.videolist.ui.VideoMutilActivity;

import rx.Subscriber;
import rx.Subscription;

public class MainActivity extends BaseActivity {

    Context mContext;
    Subscriber<UserBean> mSubscriber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        WindowUtil.disableSwipeBack(this);
    }

    public void onBtnClick(View v){
        switch (v.getId()){
            case R.id.btn_recycler_scroll:
                startActivity(new Intent(mContext, RecyclerViewScrollActivity.class));
                break;
            case R.id.btn_reflection:
                startActivity(new Intent(mContext, ReflectionActivity.class));
                break;
            case R.id.btn_go_crash:
                startActivity(new Intent(mContext, OptimizationActivity.class));
                break;
            case R.id.btn_video_play:
                startActivity(new Intent(mContext, VideoMutilActivity.class));
                break;
            case R.id.btn_xianyu_keyboard:
                startActivity(new Intent(mContext, XianYuActivity.class));
                break;
            case R.id.btn_drag:
                startActivity(new Intent(mContext, DragActivity.class));
                break;
            case R.id.btn_share:
                ShareDialogFragment.newInstance().show(getSupportFragmentManager(), "share_dialog");
                break;
            case R.id.btn_login:
                String phone = "18612532078";
                String code = "642895";
                if(mSubscriber != null) {
                    mSubscriber.unsubscribe();
                }
                mSubscriber = new Subscriber<UserBean>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(mContext, "onComplete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, "error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(UserBean user) {
                        Toast.makeText(mContext, "onNext", Toast.LENGTH_SHORT).show();
                    }
                };
                LoginRest.getInstance().loginByMobile(phone, code, mSubscriber);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSubscriber.unsubscribe();
    }
}
