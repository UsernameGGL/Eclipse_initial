package com.kms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kms.pojo.Person;

public class PersonDao extends BaseDao {
	
	public List<Person> lps(){
		List<Person> lps = new ArrayList<Person>();
		String sql = "select name, pwd from person";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = super.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Person person = new Person();
				person.setName(resultSet.getString("name"));
				person.setPwd(resultSet.getString("pwd"));
				lps.add(person);
			}
			
		} catch (Exception e) {
			System.out.println("连接失败！"+e.getMessage());
			lps = null;
		} finally{
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return lps;
	}

	public int addPerson(Person p){
		int n = -1;
		String sql = "insert into person(name,pwd,age,date) "
				+" values (?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try{
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setObject(1, p.getName());
			preparedStatement.setObject(2, p.getPwd());
			preparedStatement.setObject(3, p.getAge());
			preparedStatement.setObject(4, p.getDate());
			
			n = preparedStatement.executeUpdate();
		}catch(Exception e){
			System.out.println("插入数据失败！"+e.getMessage());
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return n;
	}
	
}
