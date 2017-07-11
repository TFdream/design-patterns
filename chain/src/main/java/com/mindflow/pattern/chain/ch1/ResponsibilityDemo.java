package com.mindflow.pattern.chain.ch1;

import com.mindflow.pattern.chain.ch1.concrete.ConcreteHandler;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 14:50
 */
public class ResponsibilityDemo {

    public static void main(String[] args) {

        ConcreteHandler handler1 = new ConcreteHandler("1");
        ConcreteHandler handler2 = new ConcreteHandler("2");
        ConcreteHandler handler3 = new ConcreteHandler("3");

        //形成调用链
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);

        Request request = new Request("3");
        handler1.handlerRequest(request);
    }
}
