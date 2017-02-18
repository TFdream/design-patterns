package com.bytebeats.pattern.chain.ch2;

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
            final int id = i;
            filters.add(new Filter() {
                @Override
                public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws Exception {
                    System.out.println("Filter_"+id+" execute...");
                    chain.doFilter(request, response);
                }
            });
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
