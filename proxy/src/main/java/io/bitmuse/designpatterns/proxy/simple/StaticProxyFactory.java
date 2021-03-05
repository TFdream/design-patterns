package io.bitmuse.designpatterns.proxy.simple;

import io.bitmuse.designpatterns.proxy.Subject;


/**
 * @author Ricky Fung
 */
public class StaticProxyFactory implements Subject {
    private Subject target;

    public StaticProxyFactory(Subject target) {
        this.target = target;
    }

    @Override
    public String echo(String msg) {
        return target.echo(msg);
    }

    @Override
    public String commit(String input) {
        return target.commit(input);
    }

    @Override
    public String rollback(String input) {
        return target.rollback(input);
    }
}
