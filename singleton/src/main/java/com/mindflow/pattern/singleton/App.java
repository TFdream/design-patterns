package com.mindflow.pattern.singleton;

import com.mindflow.pattern.singleton.ch5.Singleton;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        Singleton singleton = Singleton.INSTANCE;
        singleton.doSomeAction();
    }
}
