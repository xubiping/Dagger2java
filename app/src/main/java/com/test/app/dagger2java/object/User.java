package com.test.app.dagger2java.object;

public class User {
    String name;
    String pwd;
    public User(String name,String pwd){
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }
}
