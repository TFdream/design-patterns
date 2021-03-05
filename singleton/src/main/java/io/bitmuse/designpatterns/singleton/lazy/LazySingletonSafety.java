package io.bitmuse.designpatterns.singleton.lazy;

/**
 * 单例模式-懒汉式【线程安全】
 * @author Ricky Fung
 */
public class LazySingletonSafety {
    private volatile static LazySingletonSafety instance;

    private LazySingletonSafety(){
        System.out.println("new Singleton instance");
    }

    //double-check
    public static LazySingletonSafety getInstance(){
        if(instance==null){
            synchronized (LazySingletonSafety.class){
                if(instance==null){
                    instance = new LazySingletonSafety();
                }
            }
        }
        return instance;
    }
}
