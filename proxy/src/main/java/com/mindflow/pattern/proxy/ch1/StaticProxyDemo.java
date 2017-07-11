package com.mindflow.pattern.proxy.ch1;

import com.mindflow.pattern.proxy.service.HelloService;
import com.mindflow.pattern.proxy.service.HelloServiceImpl;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-17 19:30
 */
public class StaticProxyDemo {

    public static void main(String[] args) {

        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = new HelloServiceProxy(helloService);

        proxy.say("ricky");

        System.out.println("************************");

        proxy.echo("hello, world");
    }
}
