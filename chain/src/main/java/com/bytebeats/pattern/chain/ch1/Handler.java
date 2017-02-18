package com.bytebeats.pattern.chain.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 14:35
 */
public interface Handler {

    void handlerRequest(Request request);

    /**指定下一个处理器*/
    void setSuccessor(Handler successor);

}
