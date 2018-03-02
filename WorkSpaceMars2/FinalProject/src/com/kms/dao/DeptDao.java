package com.kms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kms.po.Dept;
import com.kms.po.JobInfo;

/** 用于封装数据库Dept表中信息与类之间的基本操作，
 * public List<JobInfo> listPerson(Dept dept) 列举部门所属所有员工的员工编号，姓名，年龄，岗位，薪金；
 * public List<Dept> listDept() 列举所有部门的基本信息；
 * public int addDept(Dept dept) 添加新的部门信息；
 * public int updateDept(Dept dept) 修改部门名称；
 * public int deleteDept(Dept dept) 删除已有部门信息
 * @author 刘嘉赓
 */
public class DeptDao extends BaseDao {
	
	/** 列举部门所属所有员工的信息：员工编号，姓名，年龄，岗位，薪金
	 * 从jsp页面需获取部门编号
	 * 如果失败则返回null
	 * @param
	 * @return List<Dept>
	 */
	public List<JobInfo> listPerson(Dept dept){
		List<JobInfo> list = new ArrayList<JobInfo>();
		String sql = "select jid, jnm, jage, pnm, jsal from dept, position, jobinfo "
				+ "where jdid = did and jpid = pid and did = ( ? ) and jsal!=-1";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = super.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setObject(1, dept.getDid());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				JobInfo jobInfo = new JobInfo();
				jobInfo.setJid(resultSet.getString("jid"));
				jobInfo.setJnm(resultSet.getString("jnm"));
				jobInfo.setJage(resultSet.getInt("jage"));
				jobInfo.setPnm(resultSet.getString("pnm"));
				jobInfo.setJsal(resultSet.getInt("jsal"));
				list.add(jobInfo);
			}
		} catch (Exception e) {
			System.out.println("连接失败！"+e.getMessage());
			list = null;
		} finally{
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println("statement关闭失败！"+e.getMessage());
			}
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("connection关闭失败！"+e.getMessage());
			}
		}
		return list;
	}
	
	/** 列举所有部门的基本信息，
	 * 如果失败则返回null
	 * @return List<Dept>
	 */
	public List<Dept> listDept(){
		List<Dept> list = new ArrayList<Dept>();
		String sql = "select did, dnm, dnum from dept";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = super.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Dept dept = new Dept();
				dept.setDid(resultSet.getInt("did"));
				dept.setDnm(resultSet.getString("dnm"));
				dept.setDnum(resultSet.getInt("dnum"));
				list.add(dept);
			}
		} catch (Exception e) {
			System.out.println("连接失败！"+e.getMessage());
			list = null;
		} finally{
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println("statement关闭失败！"+e.getMessage());
			}
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("connection关闭失败！"+e.getMessage());
			}
		}
		return list;
	}
	
	/**添加新的部门信息，返回SQL语句执行受影响的行数；
	 * 返回值为0：添加部门信息失败
	 * 返回值为1：添加部门信息成功
	 * @param
	 * @return int affect
	 */
	public int addDept(Dept dept) {
		int affect = 0;
		String sql = "insert into dept(dnm, dnum ) values (?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try{
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setObject(1, dept.getDnm());
			preparedStatement.setObject(2, 0);
			
			affect = preparedStatement.executeUpdate();
		}catch(Exception e){
			System.out.println("插入部门信息失败！"+e.getMessage());
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				System.out.println("statement关闭失败！"+e.getMessage());
			}
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("connection关闭失败！"+e.getMessage());
			}
		}
		return affect;
	}
	
	/**修改部门名称，返回SQL语句执行受影响的行数；
	 * 返回值为0：修改部门名称失败
	 * 返回值为1：修改部门名称成功
	 * @param
	 * @return int affect
	 */
	public int updateDept(Dept dept){
		int affect = 0;
		String sql = " UPDATE dept SET dnm = ( ? ) WHERE did=( ? ) ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try{
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setObject(1, dept.getDnm());
			preparedStatement.setObject(2, dept.getDid());
			
			affect = preparedStatement.executeUpdate();
		}catch(Exception e){
			System.out.println("修改部门名称失败！"+e.getMessage());
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				System.out.println("statement关闭失败！"+e.getMessage());
			}
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("connection关闭失败！"+e.getMessage());
			}
		}
		return affect;
	}
	
	/**删除已有部门信息，返回SQL语句执行受影响的行数；
	 * 返回值为0：删除已有部门信息失败
	 * 返回值为1：删除已有部门信息成功
	 * @param
	 * @return int affect
	 */
	public int deleteDept(Dept dept){
		int affect = 0;
		String sql = "delete from dept where did = ( ? ) ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try{
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setObject(1, dept.getDid());
			
			affect = preparedStatement.executeUpdate();
		}catch(Exception e){
			System.out.println("删除已有部门信息失败！"+e.getMessage());
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				System.out.println("statement关闭失败！"+e.getMessage());
			}
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("connection关闭失败！"+e.getMessage());
			}
		}
		return affect;
	}
	
}
