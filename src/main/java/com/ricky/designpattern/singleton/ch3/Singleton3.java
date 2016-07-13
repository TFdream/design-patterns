package com.ricky.designpattern.singleton.ch3;

/**
 * 单例模式-懒汉式
 *
 * @author Ricky Fung
 * @create 2016-07-13 16:24
 */
public class Singleton3 {

    private Singleton3(){
        System.out.println("call Singleton3 constructor");
    }

    public static Singleton3 getInstance(){

        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        public static final Singleton3 INSTANCE = new Singleton3();
    }
}
