package io.bitmuse.designpatterns.adapter.uml;

/**
 * @author Ricky Fung
 */
public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String request(String req) {
        String result = adaptee.specificRequest(req);
        return result;
    }
}
