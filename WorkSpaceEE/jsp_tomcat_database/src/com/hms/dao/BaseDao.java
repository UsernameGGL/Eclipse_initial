package com.hms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
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
	public Connection getConnection(){
		try {
			Connection connection = DriverManager.getConnection(URL, username, Password);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}


