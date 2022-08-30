package com.test.app.dagger2java.di;

import com.test.app.dagger2java.MainActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {TestSubModule.class})
public interface TestSubComponent {
    void injectSubMainActivity(MainActivity activity);
}
