package com.kms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kms.pojo.Person;
import com.kms.pojo.Role;

public class RoleDao_test extends BaseDao_test {
	/**
	 * 把数据库中的表数据封装到Java的对象中
	 * @return
	 */
	public List<Role> lrs() {
		List<Role> lrs = new ArrayList<Role>();
		//获得一个长度可变的Role型数组
		String sql = " SELECT   `roleid`,  `nm` FROM  `test`.`t_role`   ";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Role role=new Role();
				role.setRoleid(resultSet.getInt("roleid"));
				role.setNm(resultSet.getString("nm"));
				lrs.add(role);//为数组赋值，向集合中添加新元素
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
