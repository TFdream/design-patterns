package com.mindflow.pattern.state.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 15:25
 */
public class Context {
    private State state;//持有一个State类型的对象实例

    public void setState(State state) {
        this.state = state;
    }

    public void request(String param) {
        //转调state来处理
        state.handle(param);
    }
}
