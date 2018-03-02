package com.kms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kms.pojo.Person;

public class PersonDao extends BaseDao {
	/**
	 * 把数据库中的表数据封装到Java的对象中
	 * @return
	 */
	public List<Person> lrs() {
		List<Person> lrs = new ArrayList<Person>();
		//获得一个长度可变的Role型数组
		String sql = " SELECT   `pid`,  `pnm`,  `pwd`,  `bdate`,"
				+ "  `rid`,  `mgid`,  `icon` FROM  `test`.`person`  ";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Person person = new Person();
				person.setRid(resultSet.getInt("rid"));
				person.setBdate(resultSet.getDate("bdate"));
				person.setPnm(resultSet.getString("pnm"));
				person.setPid(resultSet.getInt("pid"));
				person.setPwd(resultSet.getString("pwd"));
				person.setMgid(resultSet.getInt("mgid"));
				person.setIcon(resultSet.getString("icon"));
				lrs.add(person);//为数组赋值，向集合中添加新元素
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			lrs = null;
		}finally{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lrs;
	}

}
