package io.bitmuse.designpatterns.proxy.cglib;

import io.bitmuse.designpatterns.proxy.RealSubject;
import io.bitmuse.designpatterns.proxy.Subject;

/**
 * CGLib动态代理
 * @author Ricky Fung
 */
public class CglibProxyDemo {

    public static void main(String[] args) {

        new CglibProxyDemo().testProxy();
    }

    private void testProxy() {

        Subject subject = new RealSubject();
        CglibProxyFactory<Subject> proxyFactory = new CglibProxyFactory(subject);
        //生成代理对象
        Subject proxy = proxyFactory.getProxy();

        proxy.commit("ricky");

        System.out.println("************************");

        proxy.echo("hello, world");
    }

}
