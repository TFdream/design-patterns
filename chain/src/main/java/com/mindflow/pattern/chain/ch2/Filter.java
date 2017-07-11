package com.mindflow.pattern.chain.ch2;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 14:02
 */
public interface Filter {

    void doFilter(ServletRequest request, ServletResponse response,
                  FilterChain chain) throws Exception;
}
