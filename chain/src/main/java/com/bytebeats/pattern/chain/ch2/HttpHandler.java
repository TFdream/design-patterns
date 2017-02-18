package com.bytebeats.pattern.chain.ch2;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 14:27
 */
public class HttpHandler {

    public void handleRequest(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("HttpHandler handleRequest invoke");
    }
}
