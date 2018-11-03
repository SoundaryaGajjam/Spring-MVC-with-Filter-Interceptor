package com.scp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	private int cnt;
	@Override
	public void destroy() {
		System.out.println("Filter : in destory");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter : in init");
		cnt=1;
	}

	@Override
	public void doFilter(ServletRequest request, 
               ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		
			System.out.println("Filter : in doFilter --> "+cnt++);
			chain.doFilter(request, response);
		
	}


}
