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
import com.test.app.dagger2java.component.DaggerMyComponent;
import com.test.app.dagger2java.object.HttpObject;
import com.test.app.dagger2java.object.QuanJuDanLiObject;

import javax.inject.Inject;

/**
 * 实现对象 和静态 功能
 */
public class FiveActivity extends AppCompatActivity {

    String TAG =  getClass().getName();
    //注入后直接用
    @Inject
    HttpObject httpObject1;


    @Inject
    QuanJuDanLiObject quanJuDanLiObject1;
    @Inject
    QuanJuDanLiObject quanJuDanLiObject2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        setTitle("FiveActivity");

        ((MainApplication)getApplication()).getFiveComponent().injectFiveActivity(this);
        TextView tv_content = findViewById(R.id.tv_content);
        tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpActivity();
            }
        });
        Log.d(TAG,"httpObject1 hashcode:"+httpObject1.hashCode());
        Log.d(TAG,"quanJuDanLiObject1 hashcode:"+quanJuDanLiObject1.hashCode());//这个和 FourActivity 里面的quanJuDanLiObject 不一样，因为在Application里面创建了新的
        Log.d(TAG,"quanJuDanLiObject2 hashcode:"+quanJuDanLiObject2.hashCode());//这个和 FourActivity 里面的quanJuDanLiObject 不一样，因为在Application里面创建了新的
    }
    public void jumpActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}