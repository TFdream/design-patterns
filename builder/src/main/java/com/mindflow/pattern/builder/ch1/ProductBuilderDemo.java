package com.mindflow.pattern.builder.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-15 13:30
 */
public class ProductBuilderDemo {

    public static void main(String[] args){

        ProductBuilder builder = new ConcreteProductBuilder();

        Director director = new Director(builder);
        director.construct();

        Product product = builder.getProduct();
        System.out.println(product);
    }
}
