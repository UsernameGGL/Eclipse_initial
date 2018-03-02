package com.hms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.PersonDao;

public class AddPersonServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决乱码问题
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String pnm = req.getParameter("pnm");
		String pwd = req.getParameter("pwd");
		String bdate = req.getParameter("bdate");
		String rid = req.getParameter("rid");
		String mgid = req.getParameter("mgid");
		String icon = req.getParameter("icon");
		Person person = new Person(pnm,pwd,bdate,rid,mgid,icon);
		PersonDao pd = new PersonDao();
		int i = pd.addPerson(person);
		System.out.println(i+"行受影响");
	}
}
