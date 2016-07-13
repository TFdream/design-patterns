package com.ricky.designpattern.singleton.ch2;

/**
 * 单例模式-懒汉式
 *
 * @author Ricky Fung
 * @create 2016-07-13 16:13
 */
public class Singleton2 {
    private static volatile Singleton2 instance;

    private Singleton2(){
        System.out.println("call Singleton2 constructor");
    }

    public static Singleton2 getInstance(){
        if(instance==null){
            synchronized (Singleton2.class){
                if(instance==null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
