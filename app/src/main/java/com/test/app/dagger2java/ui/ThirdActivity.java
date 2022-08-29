package com.test.app.dagger2java.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.test.app.dagger2java.MainActivity;
import com.test.app.dagger2java.MainApplication;
import com.test.app.dagger2java.R;
import com.test.app.dagger2java.module.DataModule;
import com.test.app.dagger2java.object.HttpObject;
import com.test.app.dagger2java.object.QuanJuDanLiObject;

import javax.inject.Inject;

/**
 * 单例 在Activity中通过Application去获取Component。
 */
public class ThirdActivity extends AppCompatActivity {

    String TAG =  getClass().getName();
    //注入后直接用
    @Inject
    QuanJuDanLiObject quanJuDanLiObject1;
    @Inject
    QuanJuDanLiObject quanJuDanLiObject2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        setTitle("ThirdActivity");
        ((MainApplication)getApplication()).getQuanJuDanLiComponent().injectThirdActivity(this);
       // httpObject.post();
        TextView tv_content = findViewById(R.id.tv_content);
        tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpActivity();
            }
        });
        Log.d(TAG,"quanJuDanLiObject1 hashcode:"+quanJuDanLiObject1.hashCode());
        Log.d(TAG,"quanJuDanLiObject2 hashcode:"+quanJuDanLiObject2.hashCode());
    }
    public void jumpActivity(){
        Intent intent = new Intent(this, FourActivity.class);
        startActivity(intent);
    }
}