package io.bitmuse.designpatterns.proxy;

/**
 * @author Ricky Fung
 */
public interface Subject {

    String echo(String msg);

    String commit(String input);

    String rollback(String input);
}
