package com.kms2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MsssageServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String msg = req.getParameter("msg");
		//获得ServletContext对象
		ServletContext application = getServletContext();
		//处理消息
		//获得消息的容器
		Object object = application.getAttribute("lms");
		List<String> lms = null;
		if(object == null){
			lms = new ArrayList<String>();
			application.setAttribute("lms", lms);
		}else{
			lms = (List<String>) object;
		}
		lms.add(0, msg);//插入；插队
		String script = "<script>window.history.go(-1)</script>";
		resp.getWriter().write(script);
	}
}
