package com.test.app.dagger2java.module;

import com.test.app.dagger2java.object.Student;
import com.test.app.dagger2java.scope.ActivityScope;
import com.test.app.dagger2java.ui.FirstScopeActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class FirstScopeModule {
    private FirstScopeActivity activity;
    public FirstScopeModule(FirstScopeActivity activity){
        this.activity =  activity;
    }

    @Provides
    @ActivityScope //添加注解实现局部单例
    public Student providerStudent(){
        return new Student();
    }

}
