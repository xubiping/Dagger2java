package com.test.app.dagger2java.component;

import com.test.app.dagger2java.module.HttpModule;
import com.test.app.dagger2java.module.QuanJuDanLiModule;
import com.test.app.dagger2java.ui.FiveActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 单例 在Component类上添加@Singleton注解。
 */
@Singleton //单例
@Component(modules = {HttpModule.class,QuanJuDanLiModule.class})
public interface FiveComponent {
    //这里的参数不能用多态
    void injectFiveActivity(FiveActivity activity);
}
