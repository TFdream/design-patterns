package com.mindflow.decorator.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-04-26 21:44
 */
public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}
