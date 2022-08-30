package com.test.app.dagger2java.duli.car;

import android.util.Log;

import javax.inject.Inject;

public class Engine {
    String TAG =  getClass().getName();

    @Inject  //Engine类是依赖提供方，因此我们需要在它的构造函数上添加@Inject
    Engine(){

    }
    public void run(){
        Log.d(TAG,"引擎转起来了~~~");
    }

}
