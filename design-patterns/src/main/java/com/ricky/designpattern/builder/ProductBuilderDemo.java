package com.ricky.designpattern.builder;

import com.ricky.designpattern.builder.ch5.ConcreteProductBuilder;
import com.ricky.designpattern.builder.ch5.Director;
import com.ricky.designpattern.builder.ch5.Product;
import com.ricky.designpattern.builder.ch5.ProductBuilder;

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
