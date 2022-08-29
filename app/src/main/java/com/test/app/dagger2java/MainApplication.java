package com.test.app.dagger2java;

import android.app.Application;

import com.test.app.dagger2java.component.DaggerFiveComponent;
import com.test.app.dagger2java.component.DaggerQuanJudanLiComponent;
import com.test.app.dagger2java.component.FiveComponent;
import com.test.app.dagger2java.component.QuanJudanLiComponent;
import com.test.app.dagger2java.module.HttpModule;
import com.test.app.dagger2java.module.QuanJuDanLiModule;

/**
 * 在Application中实例化Component对象，并提供获取Component的方法。
 */
public class MainApplication extends Application {
    private QuanJudanLiComponent quanJudanLiComponent;
    private FiveComponent fiveComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        quanJudanLiComponent = DaggerQuanJudanLiComponent.builder()
                .quanJuDanLiModule(new QuanJuDanLiModule())
                .build();
        fiveComponent = DaggerFiveComponent.builder()
                .quanJuDanLiModule(new QuanJuDanLiModule())
                //.httpModule(new HttpModule())
                .build();
    }

    public QuanJudanLiComponent getQuanJuDanLiComponent(){
        return quanJudanLiComponent;
    }
    public FiveComponent getFiveComponent(){
        return fiveComponent;
    }
}
