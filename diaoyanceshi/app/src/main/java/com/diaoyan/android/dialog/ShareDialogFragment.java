package com.diaoyan.android.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.diaoyan.android.R;


/**
 * Created by chenshaolong on 2018/2/25.
 */

public class ShareDialogFragment extends DialogFragment implements View.OnClickListener{

    public static ShareDialogFragment newInstance(){
        return new ShareDialogFragment();
    }

    Button mBtnWeiChat;
    Button mBtnTimeline;
    Button mBtnWeiBo;
    Button mBtnQQ;
    Button mBtnClose;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initDialogWindow();
        View view = inflater.inflate(R.layout.dialog_share, null);
        initView(view);
        initListener();
        return view;
    }

    protected void initDialogWindow() {
        this.getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = this.getDialog().getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        lp.windowAnimations = R.style.BottomDialogAnimation;
        window.setAttributes(lp);
        window.setBackgroundDrawable(new ColorDrawable());
    }

    protected void initView(View v){
        mBtnWeiChat = (Button) v.findViewById(R.id.btn_weichat);
        mBtnTimeline = (Button) v.findViewById(R.id.btn_timeline);
        mBtnWeiBo = (Button) v.findViewById(R.id.btn_weibo);
        mBtnQQ = (Button) v.findViewById(R.id.btn_qq);
        mBtnClose = (Button) v.findViewById(R.id.btn_close);
    }

    protected void initListener(){
        mBtnClose.setOnClickListener(this);
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(this,tag).addToBackStack(null);
        return transaction.commitAllowingStateLoss();
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_close){
            this.dismissAllowingStateLoss();
            return;
        }
    }
}
