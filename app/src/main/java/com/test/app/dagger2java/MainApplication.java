package com.test.app.dagger2java;

import android.app.Application;

import com.test.app.dagger2java.component.QuanJudanLiComponent;

public class MainApplication extends Application {
    private QuanJudanLiComponent quanJudanLiComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        //quanJudanLiComponent = DaggerQ.b
    }

    public QuanJudanLiComponent getMyComponent(){
        return quanJudanLiComponent;
    }
}
