package com.bytebeats.pattern.builder.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-15 13:21
 */
public class ConcreteProductBuilder implements ProductBuilder {

    private Product product = new Product();

    public void buildPartA() {
        product.setPartA("A");
    }

    public void buildPartB() {
        product.setPartB("B");
    }

    public void buildPartC() {
        product.setPartC("C");
    }

    public Product getProduct() {
        return product;
    }
}
