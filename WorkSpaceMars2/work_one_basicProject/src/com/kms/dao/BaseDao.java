package com.kms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {

	private static final String DriverName = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String UserName = "root";
	private static final String Password = "root";
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
			Connection connection = DriverManager.getConnection(URL, UserName, Password);
			return connection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}

