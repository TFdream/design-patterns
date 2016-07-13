package com.ricky.designpattern.singleton;

import com.ricky.designpattern.singleton.ch1.Singleton;
import com.ricky.designpattern.singleton.ch3.Singleton2;
import com.ricky.designpattern.singleton.ch4.Singleton3;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-13 16:23
 */
public class SingletonDemo {

    public static void main(String[] args){

        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);

        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2);

        Singleton3 singleton3 = Singleton3.getInstance();
        System.out.println(singleton3);

    }
}
