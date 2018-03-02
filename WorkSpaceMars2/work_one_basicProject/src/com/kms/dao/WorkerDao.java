package com.kms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kms.pojo.Worker;

public class WorkerDao extends BaseDao {
	/**
	 * 返回所有的角色信息
	 * @return
	 */
	public List<Worker> lrs(){
		List<Worker> lrs=null;
		String sql="SELECT   `workerNo`,  `deptNo`,  `jobNo` "
				+ "FROM  `test`.`worker` ";
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			lrs=new ArrayList<Worker>();
			while(resultSet.next()){
				Worker worker=new Worker();
				worker.setWorkerNo(resultSet.getInt(1));
				worker.setDeptNo(resultSet.getInt(2));
				worker.setJobNo(resultSet.getInt(3));
				//role.setNm(resultSet.getString("nm"));//注意判空
				lrs.add(worker);
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
	public Worker findOne(int workerNo){
		Worker worker=null;
		String sql="SELECT  `workerNo`,  `deptNo`,  `jobNo` FROM"
				+ "  `test`.`worker` WHERE workerNo=?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setObject(1, workerNo);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				worker = new Worker();
				worker.setDeptNo(resultSet.getInt("deptNo"));
				worker.setJobNo(resultSet.getInt("jobNo"));
				// role.setNm(resultSet.getString("nm")); // 注意判空 error
				//role.setNm(resultSet.getObject("nm") == null ? "" : resultSet.getString("nm")); // right
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
		return worker;
	}
	public int delete(int workerNo) {
		int i=0;
		String sql="DELETE FROM  `test`.`worker` WHERE `workerNo` = ? ;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setObject(1, workerNo);
			i=statement.executeUpdate();
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
	public int update(Worker worker) {
		int i=0;
		String sql="UPDATE   `test`.`worker` SET  `deptNo` = ?,  "
				+ "`jobNo` = ? WHERE `workerNo` = ? ;";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setObject(1, worker.getDeptNo());
			statement.setObject(2, worker.getJobNo());
			statement.setObject(3, worker.getWorkerNo());
			i=statement.executeUpdate();
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
