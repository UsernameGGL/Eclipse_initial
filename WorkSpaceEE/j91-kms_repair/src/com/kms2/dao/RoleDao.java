package com.kms2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kms2.pojo.Role;

public class RoleDao extends BaseDao {
	/**
	 * �����ݿ��еı����ݷ�װ��Java�Ķ�����
	 * @return
	 */
	public List<Role> lrs() {
		List<Role> lrs = new ArrayList<Role>();
		//���һ�����ȿɱ��Role������
		String sql = "  SELECT    `rid`,  `rnm` FROM  `test`.`role` ";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Role role = new Role();
				role.setRid(resultSet.getInt("rid"));
				role.setRnm(resultSet.getString("rnm"));
				lrs.add(role);//Ϊ���鸳ֵ���򼯺��������Ԫ��
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			lrs = null;
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lrs;
	}

}
