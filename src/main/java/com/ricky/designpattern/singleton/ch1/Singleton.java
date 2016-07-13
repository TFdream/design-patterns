package com.ricky.designpattern.singleton.ch1;

/**
 * 单例模式-饿汉式
 *
 * @author Ricky Fung
 * @create 2016-07-13 16:21
 */
public class Singleton {
    private static final Singleton SINGLETON = new Singleton();

    private Singleton(){
        System.out.println("call Singleton constructor");
    }

    public static Singleton getInstance(){

        return SINGLETON;
    }
}
