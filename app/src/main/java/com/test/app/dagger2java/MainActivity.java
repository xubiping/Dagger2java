package com.test.app.dagger2java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.test.app.dagger2java.component.DaggerMyComponent;
import com.test.app.dagger2java.object.DataObject;
import com.test.app.dagger2java.object.HttpObject;
import com.test.app.dagger2java.ui.FirstActivity;
import com.test.app.dagger2java.ui.FirstScopeActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    String TAG =  getClass().getName();

    //注入后直接用
    @Inject
    HttpObject httpObject1;
    @Inject
    HttpObject httpObject2;

    @Inject
    DataObject dataObject1;
    @Inject
    DataObject dataObject2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        DaggerMyComponent.create().injectMainActivity(this);
        Log.d(TAG,"httpObject1 hashcode:"+httpObject1.hashCode());
        Log.d(TAG,"httpObject2 hashcode:"+httpObject2.hashCode());//hashcode 不同说明 httpObject1 httpObject2 不是单例
        Log.d(TAG,"dataObject1 hashcode:"+dataObject1.hashCode());
        Log.d(TAG,"dataObject2 hashcode:"+dataObject2.hashCode());


        TextView tv_content = findViewById(R.id.tv_content);
        tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpActivity();
            }
        });
        TextView tv_scope = findViewById(R.id.tv_scope);
        tv_scope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpScopeActivity();
            }
        });
    }
    public void jumpActivity(){
        Log.d(TAG,"jumpActivity");
        Intent intent = new Intent(this,FirstActivity.class);
        startActivity(intent);
    }
    public void jumpScopeActivity(){
        Log.d(TAG,"jumpScopeActivity");
        Intent intent = new Intent(this, FirstScopeActivity.class);
        startActivity(intent);
    }
}