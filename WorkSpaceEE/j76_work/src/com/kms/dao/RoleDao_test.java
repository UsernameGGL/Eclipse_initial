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
	 * �����ݿ��еı����ݷ�װ��Java�Ķ�����
	 * @return
	 */
	public List<Role> lrs() {
		List<Role> lrs = new ArrayList<Role>();
		//���һ�����ȿɱ��Role������
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
				lrs.add(role);//Ϊ���鸳ֵ���򼯺��������Ԫ��
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
