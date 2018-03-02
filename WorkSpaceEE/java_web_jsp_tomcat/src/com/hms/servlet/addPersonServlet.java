package com.hms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.servlet.pojo.Person;

public class addPersonServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决乱码问题
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String pid = req.getParameter("pid");
		String pnm = req.getParameter("pnm");
		String pwd = req.getParameter("pwd");
		String bdate = req.getParameter("bdate");
		String rid = req.getParameter("rid");
		String mgid = req.getParameter("mgid");
		String icon = req.getParameter("icon");
		Person person = new Person(pid,pnm,pwd,bdate,rid,mgid,icon);
	}
}
