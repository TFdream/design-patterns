package com.bytebeats.decorator.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-04-26 21:48
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("装饰器B包装前");
        this.component.operation();
        System.out.println("装饰器B包装后");
    }

    public void featureB() {
        System.out.println("装饰器B扩展的功能");
    }
}
