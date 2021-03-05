package io.bitmuse.designpatterns.proxy.jdk;

import io.bitmuse.designpatterns.proxy.RealSubject;
import io.bitmuse.designpatterns.proxy.Subject;

/**
 * JDK动态代理
 * @author Ricky Fung
 */
public class JdkProxyDemo {

    public static void main(String[] args) {

        new JdkProxyDemo().testProxy();
    }

    public void testProxy() {

        Subject subject = new RealSubject();
        JdkProxyFactory<Subject> proxyFactory = new JdkProxyFactory(subject);
        Subject proxy = proxyFactory.getProxy();

        proxy.commit("ricky");

        System.out.println("************************");

        proxy.echo("hello, world");
    }

}
