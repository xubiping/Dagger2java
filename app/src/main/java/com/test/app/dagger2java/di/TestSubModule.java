package com.test.app.dagger2java.di;

import com.test.app.dagger2java.object.ObjectForTestSubModule;

import dagger.Module;
import dagger.Provides;

@Module
public class TestSubModule {
    @Provides
    public ObjectForTestSubModule providerObjectForTestSubModule(){
        return new ObjectForTestSubModule();
    }

}
