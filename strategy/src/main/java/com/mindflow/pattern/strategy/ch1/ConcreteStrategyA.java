package com.mindflow.pattern.strategy.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 13:03
 */
public class ConcreteStrategyA implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("具体策略1");
    }
}
