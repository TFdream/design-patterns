package com.mindflow.pattern.decorator.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-04-26 21:48
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("装饰器A包装前");
        this.component.operation();
        System.out.println("装饰器A包装后");
    }

    public void featureA() {
        System.out.println("装饰器A扩展的功能");
    }
}
