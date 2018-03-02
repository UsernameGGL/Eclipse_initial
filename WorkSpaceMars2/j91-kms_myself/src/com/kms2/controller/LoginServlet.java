package com.kms2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kms2.pojo.Person;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//Person person = new Person();
		//person.setPnm(request.getParameter("pnm"));
		//person.setPwd(request.getParameter("pwd"));
		//String rm = request.getParameter("rm");
		//if("1".equals(rm)){
		//	//通过Cookie保存登录名和密码，并且实例化Cookie对象
		//	Cookie cookie = new Cookie("pnm",person.getPnm());
		//	//携带cookie到IE客户端
		//	response.addCookie(cookie);
		//}
		//Cookie cookie = new Cookie("name","duanjingdi");
		Cookie cookie = new Cookie("name_2","duanjingdi_2");
		cookie.setMaxAge(10);//只写内存，不写硬盘
		//负数的永不消失（永远存在）
		response.addCookie(cookie);
	}
}
