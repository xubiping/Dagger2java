package com.test.app.dagger2java.component;

import com.test.app.dagger2java.MainActivity;
import com.test.app.dagger2java.module.DataModule;
import com.test.app.dagger2java.module.FirstScopeModule;
import com.test.app.dagger2java.module.HttpModule;
import com.test.app.dagger2java.scope.ActivityScope;
import com.test.app.dagger2java.ui.FirstActivity;
import com.test.app.dagger2java.ui.FirstScopeActivity;
import com.test.app.dagger2java.ui.SecondActivity;

import dagger.Component;

/**
 * 组件 用来放module的 需要哪些module
 */
@ActivityScope//添加注解实现局部单例
@Component(modules = {FirstScopeModule.class})
public interface FirstScopeComponent {
    //这里的参数不能用多态
    void inject(FirstScopeActivity activity);
}
