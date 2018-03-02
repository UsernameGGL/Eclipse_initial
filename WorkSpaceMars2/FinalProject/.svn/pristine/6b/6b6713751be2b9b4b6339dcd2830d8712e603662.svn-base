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
import com.kms.po.Position;

/** 用于封装数据库Position表中信息与类之间的基本操作，
 * public List<JobInfo> listPerson(Dept dept) 列举岗位所属所有员工的员工编号，姓名，年龄，部门，薪金；
 * public List<Position> listPosition() 列举所有岗位的基本信息；
 * public int addPosition(Position position) 添加新的岗位信息；
 * public int updatePosition(Position position) 修改岗位名称；
 * public int deletePosition(Position position) 删除已有岗位信息
 * @author 刘嘉赓
 */
public class PositionDao extends BaseDao {
	
	/** 列举岗位所属所有员工的信息：员工编号，姓名，年龄，部门，薪金
	 * 从jsp页面需获取岗位编号
	 * 如果失败则返回null
	 * @param
	 * @return List<Dept>
	 */
	public List<JobInfo> listPerson(Position position){
		List<JobInfo> list = new ArrayList<JobInfo>();
		String sql = "select jid, jnm, jage, dnm, jsal from dept, position, jobinfo "
				+ "where jdid = did and jpid = pid and pid = ( ? ) and jsal!=-1";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = super.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setObject(1, position.getPid());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				JobInfo jobInfo = new JobInfo();
				jobInfo.setJid(resultSet.getString("jid"));
				jobInfo.setJnm(resultSet.getString("jnm"));
				jobInfo.setJage(resultSet.getInt("jage"));
				jobInfo.setDnm(resultSet.getString("dnm"));
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
	
	/** 列举所有岗位的基本信息，
	 * 如果失败则返回null
	 * @return List<Dept>
	 */
	public List<Position> listPosition(){
		List<Position> list = new ArrayList<Position>();
		String sql = "select pid, pnm, pnum from position";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = super.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Position position = new Position();
				position.setPid(resultSet.getInt("pid"));
				position.setPnm(resultSet.getString("pnm"));
				position.setPnum(resultSet.getInt("pnum"));
				list.add(position);
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
	
	/**添加新的岗位信息，返回SQL语句执行受影响的行数；
	 * 返回值为0：添加岗位信息失败
	 * 返回值为1：添加岗位信息成功
	 * @param
	 * @return int affect
	 */
	public int addPosition(Position position) {
		int affect = 0;
		String sql = "INSERT INTO `test`.`position` ( `pnm`, `pnum`) VALUES  ( ?, ?) ;";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try{
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1, position.getPnm());
			preparedStatement.setObject(2, 0);
			
			affect = preparedStatement.executeUpdate();
		}catch(Exception e){
			System.out.println("插入岗位信息失败！"+e.getMessage());
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
	
	/**修改岗位名称，返回SQL语句执行受影响的行数；
	 * 返回值为0：修改岗位名称失败
	 * 返回值为1：修改岗位名称成功
	 * @param
	 * @return int affect
	 */
	public int updatePosition(Position position){
		int affect = 0;
		String sql = "update position set pnm = ( ? ) where pid = ( ? ) ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try{
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setObject(1, position.getPnm());
			preparedStatement.setObject(2, position.getPid());
			
			affect = preparedStatement.executeUpdate();
		}catch(Exception e){
			System.out.println("修改岗位名称失败！"+e.getMessage());
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
	
	/**删除已有岗位信息，返回SQL语句执行受影响的行数；
	 * 返回值为0：删除已有岗位信息失败
	 * 返回值为1：删除已有岗位信息成功
	 * @param
	 * @return int affect
	 */
	public int deletePosition(Position position){
		int affect = 0;
		String sql = "delete from position where pid = ( ? ) ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try{
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setObject(1, position.getPid());
			
			affect = preparedStatement.executeUpdate();
		}catch(Exception e){
			System.out.println("删除已有岗位信息失败！"+e.getMessage());
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
