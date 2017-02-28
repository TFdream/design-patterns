package com.bytebeats.pattern.strategy.ch1.impl;

import com.bytebeats.pattern.strategy.ch1.Strategy;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 13:03
 */
public class ConcreteStrategy1 implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("具体策略1");
    }
}
