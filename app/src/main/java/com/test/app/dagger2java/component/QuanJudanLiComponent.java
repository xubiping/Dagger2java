package com.test.app.dagger2java.component;

import com.test.app.dagger2java.module.QuanJuDanLiModule;
import com.test.app.dagger2java.ui.ThirdActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 组件 用来放module的 需要哪些module
 */
/*@Singleton //单例
@Component(modules = {QuanJuDanLiModule.class})*/
public interface QuanJudanLiComponent {
    //这里的参数不能用多态
    /*void injectMainActivity(MainActivity activity);
    void injectFirstActivity(FirstActivity activity);
    void injectSecondActivity(SecondActivity activity);*/
    void injectThirdActivity(ThirdActivity activity);
}
