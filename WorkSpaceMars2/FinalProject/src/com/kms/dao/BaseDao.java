package com.kms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {

	private static final String DriverName = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://172.20.51.14:3306/test";
	private static final String UserName = "root";
	private static final String Password = "root97";
//	为JDBC框架建立数据库驱动
	static{
		try {
			Class.forName(DriverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("导入失败");
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		try {
			Connection connection = DriverManager.getConnection(URL, UserName, Password);
			System.out.println("连接成功！");
			return connection;
		} catch (SQLException e) {
			System.out.println("连接失败！"+e.getMessage());
			return null;
		}
	}

}

