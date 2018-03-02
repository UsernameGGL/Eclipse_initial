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
		//�������jsp�ļ���ʾ����
		//��request�����ϸ�������
		
		req.setAttribute("lrs", lrs);
		//վ��ת��
		//����ת����
		//RequestDispatcher dispatcher =  req.getRequestDispatcher("/p2/listrole.jsp");
		/*�����ṩĿ��ҳ���վ��·��
		 *    / ������webcontent�ļ���
		 */
		//��ת
		//dispatcher.forward(req, resp);
		req.getRequestDispatcher("/p2/lr1.jsp").forward(req, resp);
		//ע�⣬���д����Ӧ����������������
	}
}
