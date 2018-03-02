package com.kms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kms.dao.PersonDao;
import com.kms.pojo.Person;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
//		获取登录页面信息
		Person person = new Person();
		person.setName(request.getParameter("pnm"));
		person.setPwd(request.getParameter("pwd"));
		String rm = request.getParameter("rm");
//		获取数据的登录校验信息
		PersonDao personDao = new PersonDao();
		List<Person> list = personDao.lps();
//		登录信息校验
		int flag = 1;
		for (int i=0; 1==flag && i<list.size(); i++){
			if (person.getName().equals(list.get(i).getName()) && person.getPwd().equals(list.get(i).getPwd())){
				flag = 0;
			}
		}
		if (0 == flag){//成功匹配
			//创建session
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60);
			session.setAttribute("person", person);
			//跳转首页
			response.sendRedirect("../welcome.jsp");
		}else{//未成功匹配
			PrintWriter out = response.getWriter();
			String js = " <script >alert('UserName does not exist or wrong passward');window.history.go(-1)</script>  ";
			out.write(js);
		}
	}
}
