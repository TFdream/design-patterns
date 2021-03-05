package io.bitmuse.designpatterns.proxy.simple;

import io.bitmuse.designpatterns.proxy.RealSubject;
import io.bitmuse.designpatterns.proxy.Subject;

/**
 * 静态代理
 * @author Ricky Fung
 */
public class StaticProxyDemo {

    public static void main(String[] args) {

        Subject subject = new RealSubject();
        Subject proxy = new StaticProxyFactory(subject);

        proxy.commit("ricky");

        System.out.println("************************");

        proxy.echo("hello, world");
    }
}
