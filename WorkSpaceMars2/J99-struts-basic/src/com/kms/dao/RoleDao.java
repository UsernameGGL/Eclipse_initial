package com.kms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kms.po.Role;

public class RoleDao extends BaseDao {
	/**
	 * 返回所有的角色信息
	 * @return
	 */
	public List<Role> lrs(){
		List<Role> lrs=null;
		String sql="SELECT   `roleid`,  `nm`"
				+ " FROM  `test`.`t_role`";
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			lrs=new ArrayList<Role>();
			while(resultSet.next()){
				Role role=new Role();
				role.setRoleid(resultSet.getInt("roleid"));
				//role.setNm(resultSet.getString("nm"));//注意判空
				role.setNm(resultSet.getObject("nm")==null?"":resultSet.getString("nm"));
				lrs.add(role);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		return lrs;
	}
	/**
	 * 新增role对象到数据库
	 * @param role
	 * @return
	 */
	public int add(Role role) {
		int i = 0;
		String sql = "   INSERT INTO `test`.`t_role` ( `nm`)  VALUES   (    ?     )   ";
		Connection connection = null;
		PreparedStatement statement = null;		 
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setObject(1, role.getNm());
			i = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {			
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
		return i;
	}
	
	public Role findone(int roleid) {
		Role role = null;
		String sql = "  SELECT   `roleid`, `nm`   FROM    `test`.`t_role` " +
		"   WHERE roleid = ?  ";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setObject(1, roleid);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				role = new Role();
				role.setRoleid(resultSet.getInt("roleid"));
				// role.setNm(resultSet.getString("nm")); // 注意判空 error
				role.setNm(resultSet.getObject("nm") == null ? "" : resultSet.getString("nm")); // right
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		return role;
	}

	
	
	public int edit(Role role) {
		int i = 0;
		String sql = "   UPDATE   `test`.`t_role` SET "
				+ "   `nm` =  ?   WHERE `roleid` = ?  ";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setObject(1, role.getNm());
			statement.setObject(2, role.getRoleid());
			i = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
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
		return i;
	}
}
