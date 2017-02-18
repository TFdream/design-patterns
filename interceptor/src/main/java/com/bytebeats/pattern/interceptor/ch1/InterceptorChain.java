package com.bytebeats.pattern.interceptor.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 15:28
 */
public interface InterceptorChain {

    void proceed(Request request);
}
