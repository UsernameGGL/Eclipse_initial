package com.kms2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListRoleServlet extends HttpServlet {
	private static final String DriverName = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
	private static final String username = "root";
	private static final String Password = "root";
	// 0 �˲���ֻ��Ҫִ��һ���ҽ�һ�� ΪJDBC��ܰ�װ���ݿ�����
	static {
		try {
			Class.forName(DriverName);
		} catch (ClassNotFoundException e) {
			System.err.println("��������ʧ�ܣ�" + e.getMessage());
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ѯ���ݿ�
		try {
			
			Connection connection = DriverManager.getConnection(URL,username,Password);
			String sql = " SELECT   `rid`,  `rnm`FROM  `test`.`role`  " ;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			PrintWriter out = resp.getWriter();
			Date date = new Date();
			out.print(date.toString());
			out.print("<html>");
			out.print("<head>");
			out.print("<title>");
			out.print("ListRoles");
			out.print("</title>");
			out.print("</head>");
			out.print("<body>");
			out.print("<table>");
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>");
				out.print(rs.getInt("rid"));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString("rnm"));
				out.print("</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
			rs.close();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
