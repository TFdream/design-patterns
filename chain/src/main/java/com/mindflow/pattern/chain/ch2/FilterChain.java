package com.mindflow.pattern.chain.ch2;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 13:59
 */
public interface FilterChain {

    void doFilter(ServletRequest request, ServletResponse response) throws Exception;
}
