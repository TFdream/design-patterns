package io.bitmuse.designpatterns.singleton;

import io.bitmuse.designpatterns.singleton.lazy.Singleton;

/**
 * @author Ricky Fung
 */
public class SingletonDemo {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
