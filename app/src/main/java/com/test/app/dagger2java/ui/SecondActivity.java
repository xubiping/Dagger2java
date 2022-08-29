package com.test.app.dagger2java.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.test.app.dagger2java.MainActivity;
import com.test.app.dagger2java.R;
import com.test.app.dagger2java.component.DaggerMyComponent;
import com.test.app.dagger2java.module.DataModule;
import com.test.app.dagger2java.object.DataObject;
import com.test.app.dagger2java.object.HttpObject;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    String TAG =  getClass().getName();
    //注入后直接用
    @Inject
    HttpObject httpObject1;
    @Inject
    DataObject dataObject1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        setTitle("SecondActivity");
        DaggerMyComponent.create().injectSecondActivity(this);
       // httpObject.post();
        TextView tv_content = findViewById(R.id.tv_content);
        tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpActivity();
            }
        });
        Log.d(TAG,"httpObject1 hashcode:"+httpObject1.hashCode());
        Log.d(TAG,"dataObject1 hashcode:"+dataObject1.hashCode());
    }
    public void jumpActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}