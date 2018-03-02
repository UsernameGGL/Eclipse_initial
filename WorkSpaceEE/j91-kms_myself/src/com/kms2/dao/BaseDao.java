package com.kms2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	private static final String DriverName = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
	private static final String username = "root";
	private static final String Password = "root";
	// 0 此操作只�?要执行一次且仅一�? 为JDBC框架安装数据库驱�?
	static {
		try {
			Class.forName(DriverName);
		} catch (ClassNotFoundException e) {
			System.err.println("加载驱动失败�?" + e.getMessage());
		}
	}
	public Connection getConnection(){
		try {
			Connection connection =DriverManager.getConnection(URL,username,Password);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
