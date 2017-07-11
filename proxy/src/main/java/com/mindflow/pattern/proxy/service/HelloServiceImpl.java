package com.mindflow.pattern.proxy.service;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-17 19:02
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void say(String msg) {
        System.out.println("hello, "+msg);
    }

    @Override
    public String echo(String msg) {
        return "echo->"+msg;
    }
}
