package com.bytebeats.pattern.singleton.ch5;

/**
 * 单例模式-枚举
 *
 * @author Ricky Fung
 * @create 2016-07-13 16:24
 */
public enum Singleton {
    INSTANCE("singleton");

    private String value;
    Singleton(String value){
        this.value = value;
    }

    public void doSomeAction(){
        System.out.println("doSomeAction");
    }
}
