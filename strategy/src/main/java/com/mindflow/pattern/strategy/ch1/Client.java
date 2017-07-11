package com.mindflow.pattern.strategy.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 13:05
 */
public class Client {

    public static void main(String[] args) {

        Context context = new Context();
        System.out.println("-----执行策略1-----");
        context.setStrategy(new ConcreteStrategyA());
        context.algorithm();

        System.out.println("-----执行策略2-----");
        context.setStrategy(new ConcreteStrategyA());
        context.algorithm();
    }
}
