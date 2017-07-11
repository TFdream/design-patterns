package com.mindflow.pattern.proxy.ch1;

import com.mindflow.pattern.proxy.service.HelloService;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-17 19:29
 */
public class HelloServiceProxy implements HelloService {
    private HelloService target;

    public HelloServiceProxy(HelloService target) {
        this.target = target;
    }

    @Override
    public void say(String msg) {
        target.say(msg);
    }

    @Override
    public String echo(String msg) {
        return target.echo(msg);
    }
}
