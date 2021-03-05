package io.bitmuse.designpatterns.proxy;

/**
 * @author Ricky Fung
 */
public class RealSubject implements Subject {

    @Override
    public String echo(String msg) {
        return msg;
    }

    @Override
    public String commit(String input) {
        return String.format("execute: ", input);
    }

    @Override
    public String rollback(String input) {
        return String.format("rollback: ", input);
    }
}
