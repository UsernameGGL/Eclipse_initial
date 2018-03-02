package com.kms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
//		清空session
		request.getSession().invalidate();
//		显示退出成功提示信息
		PrintWriter out = response.getWriter();
		String js = " <script>alert('Logout Successfully');window.history.go(-1)</script>  ";
		out.write(js);
//		跳转至首页
		response.sendRedirect("../welcome.jsp");
	}
}
