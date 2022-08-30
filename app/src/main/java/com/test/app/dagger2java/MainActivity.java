package com.test.app.dagger2java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.test.app.dagger2java.component.DaggerMyComponent;
import com.test.app.dagger2java.duli.car.Car;
import com.test.app.dagger2java.object.A;
import com.test.app.dagger2java.object.B;
import com.test.app.dagger2java.object.DataObject;
import com.test.app.dagger2java.object.HttpObject;
import com.test.app.dagger2java.object.ObjectForMainModule;
import com.test.app.dagger2java.object.ObjectForTestSubModule;
import com.test.app.dagger2java.object.User;
import com.test.app.dagger2java.ui.FirstActivity;
import com.test.app.dagger2java.ui.FirstScopeActivity;

import javax.inject.Inject;
import javax.inject.Named;

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

    @Named("key1")
    @Inject
    User user1;

    @Named("key2")
    @Inject
    User user2;

    @Inject
    A a;
    @Inject
    B b;
    @Inject
    ObjectForMainModule objectForMainModule;
    @Inject
    ObjectForTestSubModule objectForTestSubModule;

  /*  @Inject
    Car car;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //DaggerMyComponent.create().injectMainActivity(this);
        DaggerMyComponent.create()
                .getTestSubComponent()
                .injectSubMainActivity(this);
        Log.d(TAG,"httpObject1 hashcode:"+httpObject1.hashCode());
        Log.d(TAG,"httpObject2 hashcode:"+httpObject2.hashCode());//hashcode 不同说明 httpObject1 httpObject2 不是单例
        Log.d(TAG,"dataObject1 hashcode:"+dataObject1.hashCode());
        Log.d(TAG,"dataObject2 hashcode:"+dataObject2.hashCode());
       // user1.
        Log.d(TAG,"user1 name:"+user1.getName()+" pwd:"+user1.getPwd());
        Log.d(TAG,"user2 name:"+user2.getName()+" pwd:"+user2.getPwd());
        b.log();
        a.log();
        Log.i(TAG,"objectForMainModule"+objectForMainModule.hashCode()+"");
        Log.i(TAG,"objectForTestSubModule"+objectForTestSubModule.hashCode()+"");

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