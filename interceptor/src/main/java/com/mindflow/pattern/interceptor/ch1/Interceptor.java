package com.mindflow.pattern.interceptor.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 15:28
 */
public interface Interceptor {

    void intercept(Request request, InterceptorChain chain);
}
