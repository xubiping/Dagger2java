package com.test.app.dagger2java.duli.car;

import javax.inject.Inject;

public class Car {
    @Inject
    Engine engine;
    public Car(){
        DaggerCarComponent.builder().build().inject(this);
    }
    public Engine getEngine(){
        return this.engine;
    }
}
