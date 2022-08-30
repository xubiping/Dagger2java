package com.test.app.dagger2java.di;

import com.test.app.dagger2java.object.A;
import com.test.app.dagger2java.object.B;
import com.test.app.dagger2java.object.ObjectForMainModule;
import com.test.app.dagger2java.object.User;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    @Provides
    public ObjectForMainModule providerObjectForMainModule(){
        return new ObjectForMainModule();
    }

    @Provides
    public B providerB(){
        return new B();
    }
    @Provides
    public A providerA(B b){
        return new A(b);
    }
    @Named("key1")
    @Provides
    public User providerUser(){
        return new User("user1","123");
    }
    @Named("key2")
    @Provides
    public User providerUser2(){
        return new User("user2","456");
    }
}
