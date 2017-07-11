package com.mindflow.pattern.state.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 15:26
 */
public class Client {

    public static void main(String[] args) {

        //创建状态
        State state = new ConcreteStateA();
        //创建环境
        Context context = new Context();
        //将状态设置到环境中
        context.setState(state);
        //请求
        context.request("test");
    }
}
