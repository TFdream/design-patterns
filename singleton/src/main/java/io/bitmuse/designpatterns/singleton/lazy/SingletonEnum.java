package io.bitmuse.designpatterns.singleton.lazy;

/**
 * 单例模式-枚举
 * @author Ricky Fung
 */
public enum SingletonEnum {
    INSTANCE("singleton");

    private String value;
    SingletonEnum(String value){
        this.value = value;
    }

    public void doSomeAction(){
        System.out.println("doSomeAction");
    }
}
