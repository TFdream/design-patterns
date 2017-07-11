package com.mindflow.pattern.interceptor.ch1;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 15:32
 */
public class InterceptorChainImpl implements InterceptorChain {
    private int pos;
    private List<Interceptor> interceptors;

    public InterceptorChainImpl(List<Interceptor> interceptors) {
        this.interceptors = interceptors;
        this.pos = 0;
    }

    @Override
    public void proceed(Request request) {

        if(pos<interceptors.size()){
            Interceptor interceptor = interceptors.get(pos++);
            interceptor.intercept(request, this);
        }
    }
}
