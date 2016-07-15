package com.ricky.designpattern.builder.ch5;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-15 13:20
 */
public interface ProductBuilder {

    public void buildPartA();
    public void buildPartB();
    public void buildPartC();

    public Product getProduct();
}
