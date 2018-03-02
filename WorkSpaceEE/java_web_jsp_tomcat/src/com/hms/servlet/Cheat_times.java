package com.hms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cheat_times extends HttpServlet {
	long times;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		String string = getInitParameter("param_1");
		times = Integer.parseInt(string);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		times+=9990;
		String out1 =new String("你是本网页的第<h1>"+times+"</h1>位访问者");
		Enumeration<String> enumeration = getInitParameterNames();
		while(enumeration.hasMoreElements()){
			out1+=new String("<br>");
			out1+=enumeration.nextElement();
		}
		out.println(out1);
	}
}
