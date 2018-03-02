package com.kms2.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kms2.dao.RoleDao;
import com.kms2.pojo.Role;

public class ListRole2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		RoleDao rd =new RoleDao();
		List<Role> lrs =  rd.lrs();		
		//必须借助jsp文件显示数据
		//向request对象上附着数据
		
		req.setAttribute("lrs", lrs);
		//站内转发
		//定义转发器
		//RequestDispatcher dispatcher =  req.getRequestDispatcher("/p2/listrole.jsp");
		/*必须提供目标页面的站内路径
		 *    / ：代表webcontent文件夹
		 */
		//跳转
		//dispatcher.forward(req, resp);
		req.getRequestDispatcher("/p2/lr1.jsp").forward(req, resp);
		//注意，此行代码后不应该再有其它代码了
	}
}
