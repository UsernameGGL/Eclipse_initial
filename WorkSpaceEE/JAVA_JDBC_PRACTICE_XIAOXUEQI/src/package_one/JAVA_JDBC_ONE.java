package package_one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JAVA_JDBC_ONE {
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String username = "root";
	private static final String password = "root";
	static{
		try {
			Class.forName("java.sql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("����ʧ�ܣ�"+e.getMessage());
		}
	}
	@Test
	public void addEmp(){
		String sql="INSERT INTO DEPT_2 VALUES(14,'NAME_14','LOC_14');";
		try {
			//1���������ݿ������
			Connection connection=DriverManager.getConnection(URL, username, password);
			//2��������SQL����Statement
			Statement statement=(Statement) connection.createStatement();
			//3ִ��SQL������Ӱ���¼������
			int i=((java.sql.Statement) statement).executeUpdate(sql);
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void addEmp_1(){
		//1���������ݿ������
		String sql="INSERT INTO DEPT_2 VALUES(?,?,?);";
		try {
			Connection connection=DriverManager.getConnection(URL, username, password);
			//2��������SQL����Statement
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, 20);
			statement.setString(2, "NAME_20");
			statement.setString(3, "LOC_20");
			//3ִ��SQL������Ӱ���¼������
			int i=statement.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
