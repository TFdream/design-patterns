package com.mindflow.pattern.chain.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 14:14
 */
public class FilterChainDemo {

    public static void main(String[] args) {

        List<Filter> filters = new ArrayList<>();
        for(int i=1; i<=5;i++){
            filters.add(new DemoFilter("Filter_"+i));
        }

        ServletRequest request = new ServletRequest();
        ServletResponse response = new ServletResponse();
        HttpHandler httpHandler = new HttpHandler();    //http请求处理器
        FilterChain filterChain = new FilterChainImpl(filters, httpHandler);
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
