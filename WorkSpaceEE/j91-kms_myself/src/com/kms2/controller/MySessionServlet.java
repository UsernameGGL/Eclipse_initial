package com.kms2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MySessionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//用session在服务器端保存数据是十分危险的
		HttpSession session = request.getSession();//--->request.getSession(true);
		System.out.println(session.isNew());//判断此session对象是否在当前请求中创建
		System.out.println(session.getId());//获取每个sesion对应的唯一ID
		System.out.println(session.getCreationTime());//获得创建时间
		System.out.println(session.getLastAccessedTime());//获得最后一次访问的时间
		System.out.println(session.getMaxInactiveInterval());//获得这个会话中两次请求的最长的时间
		session.setMaxInactiveInterval(10);//设置这个会话中两次请求的最大时间间隔
		session.invalidate();//让服务器强行删除session
	}
}
