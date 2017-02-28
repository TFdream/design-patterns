package com.bytebeats.pattern.state.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 15:25
 */
public class ConcreteState1 implements State {

    @Override
    public void handle(String param) {
        System.out.println("ConcreteState1 handle param:" + param);
    }
}
