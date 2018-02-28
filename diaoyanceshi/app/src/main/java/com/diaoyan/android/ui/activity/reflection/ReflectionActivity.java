package com.diaoyan.android.ui.activity.reflection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.diaoyan.android.R;
import com.diaoyan.android.base.BaseActivity;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by chenshaolong on 2017/11/3.
 */

public class ReflectionActivity extends BaseActivity {

    TextView mTvReflection;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflection);
        mTvReflection = (TextView) findViewById(R.id.tv_reflection);
        getReflection();
    }



    private void getReflection(){
        try {
            Class c = Class.forName("java.lang.String");
            Field[] fields = c.getDeclaredFields();
            StringBuffer sb = new StringBuffer();
            sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() + "{\n");
            for (Field field : fields) {
                sb.append("\t");
                sb.append(Modifier.toString(field.getModifiers()) + " ");
                sb.append(field.getType().getSimpleName() + " ");
                sb.append(field.getName() + ";\n");
            }
            sb.append("}\n");
            mTvReflection.setText(sb.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
