package com.test.app.dagger2java.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.test.app.dagger2java.MainActivity;
import com.test.app.dagger2java.R;
import com.test.app.dagger2java.module.DataModule;
import com.test.app.dagger2java.object.HttpObject;
import com.test.app.dagger2java.object.QuanJuDanLiObject;

import javax.inject.Inject;

public class ThirdActivity extends AppCompatActivity {

    String TAG =  getClass().getName();
    //注入后直接用
    @Inject
    QuanJuDanLiObject quanJuDanLiObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        setTitle("ThirdActivity");
      //  Dagg.create().injectThirdActivity(this);
       // httpObject.post();
        TextView tv_content = findViewById(R.id.tv_content);
        tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpActivity();
            }
        });
        Log.d(TAG,"quanJuDanLiObject hashcode:"+quanJuDanLiObject.hashCode());
    }
    public void jumpActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}