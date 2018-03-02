package com.kms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kms.dao.PersonDao;
import com.kms.pojo.Person;

public class RegServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
//		获取登录页面信息
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String age = request.getParameter("age");
		String date = request.getParameter("date");
//		将页面获取的数据封装到Person类中并写入数据库
		Person person = new Person(name,pwd,age,date);
		PersonDao personDao = new PersonDao();
		int n = personDao.addPerson(person);
		System.out.println("受影响的行数为："+n);
//		显示注册成功提示信息
		PrintWriter out = response.getWriter();
		String js = " <script>alert('Register Successfully');window.history.go(-1)</script>  ";
		out.write(js);
//		跳转至首页
		response.sendRedirect("../welcome.jsp");
	}
}
