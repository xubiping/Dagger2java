package com.test.app.dagger2java.module;

import com.test.app.dagger2java.object.QuanJuDanLiObject;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//写module类 (注解Module). Provides方法提供对象(Provides注解)
//@Module
public class QuanJuDanLiModule {

    //@Singleton  //单例
    //@Provides
    public QuanJuDanLiObject providerHttpObject(){
        return new QuanJuDanLiObject();
    }
}
