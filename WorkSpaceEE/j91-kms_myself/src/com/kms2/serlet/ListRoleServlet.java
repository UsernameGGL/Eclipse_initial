package com.kms2.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListRoleServlet extends HttpServlet {
	private static final String DriverName = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String username = "root";
	private static final String Password = "root";
	//0此操作只需执行一次且仅一次为JDBC框架安装数据库驱动
	static{
		try {
			Class.forName(DriverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Connection connection = DriverManager.getConnection(URL,username,Password);
			//sql要注意填上值
			String sql = " ";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			PrintWriter out = resp.getWriter();
			out.print("<html>");
			out.print("<head>");
			out.print("<title>");
			out.print("<ListRoles>");
			out.print("</title>");
			out.print("</head>");
			out.print("<body>");
			out.print("<table>");
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>");
				out.print(rs.getInt(1));
				out.print(rs.getString(2));
				out.print("</td>");
				out.print("</tr>");
			}
			out.print(rs);
			out.print("<html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
