package com.test.app.dagger2java;

import android.app.Application;

import com.test.app.dagger2java.component.DaggerQuanJudanLiComponent;
import com.test.app.dagger2java.component.QuanJudanLiComponent;
import com.test.app.dagger2java.module.QuanJuDanLiModule;

/**
 * 在Application中实例化Component对象，并提供获取Component的方法。
 */
public class MainApplication extends Application {
    private QuanJudanLiComponent quanJudanLiComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        quanJudanLiComponent = DaggerQuanJudanLiComponent.builder()
                .quanJuDanLiModule(new QuanJuDanLiModule())
                .build();
    }

    public QuanJudanLiComponent getQuanJuDanLiComponent(){
        return quanJudanLiComponent;
    }
}
