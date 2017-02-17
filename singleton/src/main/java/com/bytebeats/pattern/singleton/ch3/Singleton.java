package com.bytebeats.pattern.singleton.ch3;

/**
 * 单例模式-懒汉式
 *
 * @author Ricky Fung
 * @create 2016-07-13 16:13
 */
public class Singleton {
    private volatile static Singleton instance;

    private Singleton(){
        System.out.println("new Singleton instance");
    }

    //double-check
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
