package com.test.app.dagger2java.component;

import com.test.app.dagger2java.MainActivity;
import com.test.app.dagger2java.di.TestModule;
import com.test.app.dagger2java.di.TestSubComponent;
import com.test.app.dagger2java.module.DataModule;
import com.test.app.dagger2java.module.HttpModule;
import com.test.app.dagger2java.ui.FirstActivity;
import com.test.app.dagger2java.ui.SecondActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 组件 用来放module的 需要哪些module
 */
//@Singleton //单例
@Component(modules = {HttpModule.class, DataModule.class, TestModule.class,})
public interface MyComponent {
    //这里的参数不能用多态
    //void injectMainActivity(MainActivity activity); // 屏蔽了这个 因为TestSubComponent 模块里面有关联MainActivity
    void injectFirstActivity(FirstActivity activity);
    void injectSecondActivity(SecondActivity activity);
    TestSubComponent getTestSubComponent();//子模块
}
