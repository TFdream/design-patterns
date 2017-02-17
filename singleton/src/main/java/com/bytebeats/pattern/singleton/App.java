package com.bytebeats.pattern.singleton;

import com.bytebeats.pattern.singleton.ch5.Singleton;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        Singleton singleton = Singleton.INSTANCE;
        singleton.doSomeAction();
    }
}
