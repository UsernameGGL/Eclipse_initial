package com.kms2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 实现Filter接口
 * @author 12515
 *
 */
public class MyFilter implements Filter{
	
	@Override
	public void destroy() {
		//容器销毁时执行
		System.out.println("public void destroy()");
		
	}
	/**
	 * 过滤器的核心方法
	 * ServletRequest request：请求对象
	 * ServletResponse response：响应对象
	 * FilterChain chain：执行对象
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("------before-----");
		//改变请求既定路径
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		Object object = session.getAttribute("person");
		if(object ==null){
			//request.getRequestDispatcher("/p3/login.jsp");
			HttpServletResponse httpServletResponse = (HttpServletResponse)response;
			httpServletResponse.sendRedirect("/j91/p3/login.jsp");//绝对路径
		}else{
			
		}
		/**
		 * chain.doFilter(request, response);之前代码先于servlet执行
		 * chain.doFilter(request, response);之后代码后于servlet执行
		 */
		System.out.println("-------after-----");
	}
	@Override
	public void init(FilterConfig cfg) throws ServletException {
		//通过FilterConfig对象读取信息
		//cfg.get
		System.out.println("public void init(FilterConfig arg0) throws ServletException");
	}
	
}
