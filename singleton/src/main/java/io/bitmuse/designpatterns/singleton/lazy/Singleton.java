package io.bitmuse.designpatterns.singleton.lazy;

/**
 * 单例模式-懒汉式
 * @author Ricky Fung
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
