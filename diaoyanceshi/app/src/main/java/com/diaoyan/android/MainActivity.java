package com.diaoyan.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.diaoyan.android.recyclerviewscroll.RecyclerViewScrollActivity;
import com.diaoyan.android.reflection.ReflectionActivity;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    String mTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mTest = "adasfkasppll";
    }

    public void onBtnClick(View v){
        switch (v.getId()){
            case R.id.btn_recycler_scroll:
                startActivity(new Intent(mContext, RecyclerViewScrollActivity.class));
                break;
            case R.id.btn_reflection:
                startActivity(new Intent(mContext, ReflectionActivity.class));
                break;
        }
    }
}
