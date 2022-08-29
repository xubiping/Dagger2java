package com.test.app.dagger2java.module;

import com.test.app.dagger2java.object.QuanJuDanLiObject;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 想要提供的对象是单例，需要加上@Singleton注解
 * 但是最新版本的Dagger2已经不需要在Module上添加@Singleton注解(不然编译会报错)，只需要在下面的provider和Component上添加@Singleton即可。
 */
@Module
public class QuanJuDanLiModule {

    @Singleton  //单例
    @Provides
    public QuanJuDanLiObject providerHttpObject(){
        return new QuanJuDanLiObject();
    }
}
