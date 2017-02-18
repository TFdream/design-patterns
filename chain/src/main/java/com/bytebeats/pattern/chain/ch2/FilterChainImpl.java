package com.bytebeats.pattern.chain.ch2;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 14:02
 */
public class FilterChainImpl implements FilterChain {
    private int pos;    //当前位置
    private List<Filter> filters;
    private HttpHandler next;

    public FilterChainImpl(List<Filter> filters, HttpHandler next) {
        this.filters = filters;
        this.next = next;
        this.pos = 0;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws Exception {
        if (pos >= filters.size()) {
            this.next.handleRequest(request, response);
        } else {
            Filter filter =  filters.get(pos++);
            filter.doFilter(request, response, this);
        }
    }
}
