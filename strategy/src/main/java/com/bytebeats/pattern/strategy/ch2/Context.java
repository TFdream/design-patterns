package com.bytebeats.pattern.strategy.ch2;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 13:01
 */
public class Context {
    private Sort strategy;

    public void setStrategy(Sort strategy){
        this.strategy = strategy;
    }

    public void sort(int[] arr, int start, int end) {
        strategy.sort(arr, start, end);
    }
}
