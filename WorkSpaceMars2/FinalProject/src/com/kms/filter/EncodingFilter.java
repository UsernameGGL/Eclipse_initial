package com.kms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private String encoding = "UTF-8";
	
	@Override
	public void init(FilterConfig config) throws ServletException {
//		System.out.println("---EncodingFilter---init----------------------");
		encoding = config.getInitParameter("encoding");
		if (encoding==null||encoding.length()==0){
			encoding = "UTF-8";
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("---EncodingFilter----before--------doFilter-----------------");
		chain.doFilter(request, response);
//		System.out.println("---EncodingFilter----after--------doFilter-----------------");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
