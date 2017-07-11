package com.mindflow.pattern.builder.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-15 13:20
 */
public interface ProductBuilder {

    void buildPartA();
    void buildPartB();
    void buildPartC();

    Product getProduct();
}
