package com.mindflow.pattern.chain.ch2;

public class DemoFilter implements Filter {
	private String name;

	public DemoFilter(String name) {
		this.name = name;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws Exception {
		System.out.println(name+" execute...");
		chain.doFilter(request, response);
	}
}