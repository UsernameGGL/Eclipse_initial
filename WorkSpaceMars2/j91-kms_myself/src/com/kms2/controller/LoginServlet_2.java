package com.kms2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kms2.pojo.Person;

public class LoginServlet_2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Person person = new Person();
		person.setPnm(request.getParameter("pnm"));
		person.setPwd(request.getParameter("pwd"));
		if("sa".equals(person.getPnm())&&"sa".equals(person.getPwd())){
			//创建session
			person.setNm("赵本山");
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(20);
			session.setAttribute("person", person);
			//request.getRequestDispatcher("url").forward(request, response);
			//跳转
			/**响应的重定向
			 * 
			 */
			response.sendRedirect("../index.jsp");
		}else{
			PrintWriter out = response.getWriter();
			String js = "<script>alert('error');window.history.go(-1)</script>";
			out.write(js);
		}
	}
}
