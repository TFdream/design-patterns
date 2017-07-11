package com.mindflow.pattern.chain.ch1.concrete;

import com.mindflow.pattern.chain.ch1.Handler;
import com.mindflow.pattern.chain.ch1.Request;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 14:37
 */
public class ConcreteHandler implements Handler {
    private String type; //处理请求类型

    private Handler successor;

    public ConcreteHandler(String type) {
        this.type = type;
    }

    @Override
    public void handlerRequest(Request request) {

        if(type.equals(request.getType())){ //是自己的任务
            System.out.println("Handler_"+type+" handlerRequest exec......");
            return;
        } else{  //不是自己的任务, 传递给下一个
            if(this.successor!=null){
                System.out.println("Handler_"+type+" handlerRequest dispatch to successor");
                this.successor.handlerRequest(request);
            } else{
                System.out.println("Handler_"+type+" no next handler");
            }
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

}
