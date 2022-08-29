package com.test.app.dagger2java.scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import javax.inject.Scope;

/**
 * 自定义Scope 范围作用域
 * 声明这个注解可以使对象在同一个Activity中实现单例
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {

}
