package com.mindflow.pattern.singleton.ch4;

/**
 * 单例模式-懒汉式
 *
 * @author Ricky Fung
 * @create 2016-07-13 16:24
 */
public class Singleton {

    private Singleton(){
        System.out.println("new Singleton instance");
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        public static final Singleton INSTANCE = new Singleton();
    }
}
