package io.bitmuse.designpatterns.singleton.hunger;

/**
 * 单例模式-饿汉式
 * @author Ricky Fung
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton(){
        System.out.println("new Singleton instance");
    }

    public static Singleton getInstance(){
        return INSTANCE;
    }
}
