package com.bytebeats.pattern.interceptor.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 15:35
 */
public class InterceptorDemo {

    public static void main(String[] args) {

        List<Interceptor> interceptors = new ArrayList<>();

        for(int i=1; i<=5; i++){
            final int id = i;
            interceptors.add(new Interceptor() {
                @Override
                public void intercept(Request request, InterceptorChain chain) {

                    System.out.println("Interceptor_"+id+" intercept...");
                    chain.proceed(request);
                }
            });
        }

        Request request = new Request();
        InterceptorChain chain = new InterceptorChainImpl(interceptors);
        chain.proceed(request);
    }
}
