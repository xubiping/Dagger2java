package com.test.app.dagger2java.object;

import android.util.Log;

public class A {
    String TAG =  getClass().getName();
    public A(B b){
        b.log();
    }
    public void log(){
        Log.d(TAG,"A log");
    }
}
