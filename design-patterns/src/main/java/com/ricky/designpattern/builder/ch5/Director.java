package com.ricky.designpattern.builder.ch5;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-15 13:27
 */
public class Director {

    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}
