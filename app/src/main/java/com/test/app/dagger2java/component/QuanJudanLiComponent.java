package com.test.app.dagger2java.component;

import com.test.app.dagger2java.module.QuanJuDanLiModule;
import com.test.app.dagger2java.ui.FourActivity;
import com.test.app.dagger2java.ui.ThirdActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 单例 在Component类上添加@Singleton注解。
 */
@Singleton //单例
@Component(modules = {QuanJuDanLiModule.class})
public interface QuanJudanLiComponent {
    //这里的参数不能用多态
    /*void injectMainActivity(MainActivity activity);
    void injectFirstActivity(FirstActivity activity);
    void injectSecondActivity(SecondActivity activity);*/

    void injectThirdActivity(ThirdActivity activity);
    void injectFourActivity(FourActivity activity);
}
