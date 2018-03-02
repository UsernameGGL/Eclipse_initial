package com.hms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pnm = req.getParameter("pnm");
		System.out.println(pnm);
		resp.setCharacterEncoding("GB2312");
		PrintWriter writer=resp.getWriter();
		writer.println(pnm+"<br>成功进入！");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String onName=req.getParameter("onName");//登录名
		String gender=req.getParameter("gender");//性别
		String [] enjoy = req.getParameterValues("enjoy");//爱好
		String password = req.getParameter("password");//密码
		String defpassword = req.getParameter("defpassword");//确认密码
		String money = req.getParameter("money");//期望薪水
		String email = req.getParameter("email");//邮箱
		String adress = req.getParameter("adress");//通信地址
		String zipcode = req.getParameter("zipcode");//邮编
		String number = req.getParameter("tel");//电话号码
		String icon = req.getParameter("icon");
		System.out.println(onName);
		System.out.println(gender);
		for( String e : enjoy){
			System.out.println(e);
		}
		System.out.println(password);
		System.out.println(defpassword);
		System.out.println(money);
		System.out.println(email);
		System.out.println(adress);
		System.out.println(zipcode);
		System.out.println(number);
		System.out.println(icon);
	}
}
