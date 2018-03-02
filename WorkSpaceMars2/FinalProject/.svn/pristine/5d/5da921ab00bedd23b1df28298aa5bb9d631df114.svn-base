package com.kms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kms.po.Change;
import com.kms.po.KeyWord;

/**封装从数据库中查询所需的在职员工变更记录信息
 * public List<Change> listChangeByKW(KeyWord keyW) 
 * public List<Change> listChange() 查询在职员工变更记录报表的信息，封装在返回的List<String []>中
 * public int addChange(Change change) 添加新的变更记录，返回SQL语句执行受影响的行数
 * @author 刘嘉赓
 *
 */
public class ChangeDao extends BaseDao {
	
	/** 按关键字（姓名或操作名称）和日期查询在职员工变更记录报表的信息，封装在返回的List<String []>中
	 * 信息从左到右依次为：
	 * 记录编号，员工姓名，变更操作，原部门/岗位名称，现部门/岗位名称，原薪金，现薪金，变更时间
	 * @return List<Change>
	 */
	public List<Change> listChangeByKW(KeyWord keyW){
		List<Change> list = new ArrayList<Change>();
		String sql = " SELECT `rid`,`cnm`,`cop`,`cold`,`cnew`,`cosal`,`cnsal`,`cdate` FROM `test`.`change` "
				+ " where ( cnm like ? or cop like ? ) and cdate between ? and ? ";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = super.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setObject(1, "%"+keyW.getKeyWord()+"%");
			statement.setObject(2, "%"+keyW.getKeyWord()+"%");
			statement.setObject(3, keyW.getFormer());
			statement.setObject(4, keyW.getLatter());
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Change change = new Change();
				change.setRid(resultSet.getInt("rid"));
				change.setCnm(resultSet.getString("cnm"));
				change.setCop(resultSet.getString("cop"));
				change.setCold(resultSet.getString("cold"));
				change.setCnew(resultSet.getString("cnew"));
				change.setCosal(resultSet.getInt("cosal"));
				change.setCnsal(resultSet.getInt("cnsal"));
				change.setCdate(resultSet.getDate("cdate"));
				list.add(change);
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
	
	/** 查询在职员工变更记录报表的信息，封装在返回的List<String []>中
	 * 信息从左到右依次为：
	 * 记录编号，员工姓名，变更操作，原部门/岗位名称，现部门/岗位名称，原薪金，现薪金，变更时间
	 * @return List<Change>
	 */
	public List<Change> listChange(){
		List<Change> list = new ArrayList<Change>();
		String sql = " SELECT `rid`,`cnm`,`cop`,`cold`,`cnew`,`cosal`,`cnsal`,`cdate` FROM `test`.`change`";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = super.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Change change = new Change();
				change.setRid(resultSet.getInt("rid"));
				change.setCnm(resultSet.getString("cnm"));
				change.setCop(resultSet.getString("cop"));
				change.setCold(resultSet.getString("cold"));
				change.setCnew(resultSet.getString("cnew"));
				change.setCosal(resultSet.getInt("cosal"));
				change.setCnsal(resultSet.getInt("cnsal"));
				change.setCdate(resultSet.getDate("cdate"));
				list.add(change);
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
	
	/**添加新的变更记录，返回SQL语句执行受影响的行数；
	 * 返回值为0：添加部门信息失败
	 * 返回值为1：添加部门信息成功
	 * @param change
	 * @return int
	 */
	public int addChange(Change change) {
		int affect = 0;
		String sql = "INSERT INTO `test`.`change` (   `cnm`,  `cop`,  `cold`,  `cnew`,"
				+ "  `cosal`,  `cnsal`,  `cdate`) VALUES  (      ?,    ?,"
				+ "    ?,    ?,    ?,   ?,    ?  ) ;";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try{
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setObject(1, change.getCnm());
			preparedStatement.setObject(2, change.getCop());
			preparedStatement.setObject(3, change.getCold());
			preparedStatement.setObject(4, change.getCnew());
			preparedStatement.setObject(5, change.getCosal());
			preparedStatement.setObject(6, change.getCnsal());
			change.setCdate();
			preparedStatement.setObject(7, change.getCdate());
			
			affect = preparedStatement.executeUpdate();
		}catch(Exception e){
			System.out.println("插入新的变更记录失败！"+e.getMessage());
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
