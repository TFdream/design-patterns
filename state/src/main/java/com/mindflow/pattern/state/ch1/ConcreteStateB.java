package com.mindflow.pattern.state.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 15:25
 */
public class ConcreteStateB implements State {

    @Override
    public void handle(String param) {
        System.out.println("ConcreteStateB handle param:" + param);
    }
}
