package com.kms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kms.po.Change;
import com.kms.po.JobInfo;

/**
 * 封装操作数据库jobInfo表的类
 * public List<JobInfo> listDept()罗列员工在职信息
 * public int updateJobInfo(JobInfo jobInfo)修改员工在职信息
 * @author 高国亮
 *
 */
public class JobInfoDao extends BaseDao {
	
	/** 列举员工在职信息
	 * 如果失败则返回null
	 * @return List<Dept>
	 */
	public List<JobInfo> listJobInfo(){
		Map<Integer, String> deptMap = new WorkerDao().deptConvert();
		Map<Integer, String> positionMap = new WorkerDao().positionConvert();
		List<JobInfo> list = new ArrayList<JobInfo>();
		String sql = "select jid, jnm, jage, jpid, jdid, jsal from jobinfo where jsal!=-1;";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = super.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				JobInfo jobInfo = new JobInfo();
				jobInfo.setJid(resultSet.getString(1));
				jobInfo.setJnm(resultSet.getString(2));
				jobInfo.setJage(resultSet.getInt(3));
				jobInfo.setJpid(resultSet.getInt(4));
				jobInfo.setPnm(positionMap.get(jobInfo.getJpid()));
				jobInfo.setJdid(resultSet.getInt(5));
				jobInfo.setDnm(deptMap.get(jobInfo.getJdid()));
				jobInfo.setJsal(resultSet.getInt(6));
				System.out.println("--------"+jobInfo.getDnm()+"------"+jobInfo.getPnm()+"------------");
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
	
	/**修改员工在职信息，返回SQL语句执行受影响的行数；
	 * 返回值为0：修改部门名称失败
	 * 返回值为1：修改部门名称成功
	 * @param
	 * @return int affect
	 */
	public int updateJobInfo(JobInfo jobInfo){
		int affect = 0;
		Map<Integer, String> deptMap = new WorkerDao().deptConvert();
		Map<Integer, String> positionMap = new WorkerDao().positionConvert();
		Change change = new Change();
		ChangeDao changeDao = new ChangeDao();
		String sql = "update jobInfo set jpid =  ? , jdid=?, jsal=? where jid =  ?  ";
		String sqlSelectOld = "select jnm, jdid, jpid, jsal from jobinfo where jid =  ?  ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preStatementSelectOld = null;
		ResultSet resultSet = null;
		try{
			connection = super.getConnection();
//			查询变更前的员工信息记录
			preStatementSelectOld = connection.prepareStatement(sqlSelectOld);
			preStatementSelectOld.setObject(1, jobInfo.getJid());
			resultSet = preStatementSelectOld.executeQuery();
			
//			更新jobinfo数据库
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1, jobInfo.getJpid());
			preparedStatement.setObject(2, jobInfo.getJdid());
			preparedStatement.setObject(3, jobInfo.getJsal());
			preparedStatement.setObject(4, jobInfo.getJid());
			affect = preparedStatement.executeUpdate();
			
//			添加变更记录
			if (resultSet.next()){
				change.setCnm(resultSet.getString("jnm"));
				change.setCosal(resultSet.getInt("jsal"));
				change.setCnsal(jobInfo.getJsal());
				change.setCdate();
				if (resultSet.getInt("jdid") != jobInfo.getJdid()&&
						resultSet.getInt("jpid") == jobInfo.getJpid()&&
						resultSet.getInt("jsal") == jobInfo.getJsal()){
					change.setCop("部门变更");
					change.setCold(deptMap.get(jobInfo.getJdid()));
					change.setCnew(deptMap.get(resultSet.getInt("jdid")));
				}
				else if (resultSet.getInt("jdid") == jobInfo.getJdid()&&
						resultSet.getInt("jpid") != jobInfo.getJpid()&&
						resultSet.getInt("jsal") == jobInfo.getJsal()){
					change.setCop("岗位变更");
					change.setCold(positionMap.get(jobInfo.getJpid()));
					change.setCnew(positionMap.get(resultSet.getInt("jpid")));
				}
				else if (resultSet.getInt("jdid") == jobInfo.getJdid()&&
						resultSet.getInt("jpid") == jobInfo.getJpid()&&
						resultSet.getInt("jsal") < jobInfo.getJsal()){
					change.setCop("加薪");
					change.setCold(deptMap.get(jobInfo.getJdid())+","+positionMap.get(jobInfo.getJpid()));
					change.setCnew(deptMap.get(resultSet.getInt("jdid"))+","+positionMap.get(resultSet.getInt("jpid")));
				}
				else if (resultSet.getInt("jdid") == jobInfo.getJdid()&&
						resultSet.getInt("jpid") == jobInfo.getJpid()&&
						resultSet.getInt("jsal") > jobInfo.getJsal()){
					change.setCop("降薪");
					change.setCold(deptMap.get(jobInfo.getJdid())+","+positionMap.get(jobInfo.getJpid()));
					change.setCnew(deptMap.get(resultSet.getInt("jdid"))+","+positionMap.get(resultSet.getInt("jpid")));
				}
				else if (resultSet.getInt("jdid") != jobInfo.getJdid()&&
						resultSet.getInt("jpid") == jobInfo.getJpid()&&
						resultSet.getInt("jsal") < jobInfo.getJsal()){
					change.setCop("部门变更，加薪");
					change.setCold(deptMap.get(jobInfo.getJdid()));
					change.setCnew(deptMap.get(resultSet.getInt("jdid")));
				}
				else if (resultSet.getInt("jdid") != jobInfo.getJdid()&&
						resultSet.getInt("jpid") == jobInfo.getJpid()&&
						resultSet.getInt("jsal") > jobInfo.getJsal()){
					change.setCop("部门变更，降薪");
					change.setCold(deptMap.get(jobInfo.getJdid()));
					change.setCnew(deptMap.get(resultSet.getInt("jdid")));
				}
				else if (resultSet.getInt("jdid") == jobInfo.getJdid()&&
						resultSet.getInt("jpid") != jobInfo.getJpid()&&
						resultSet.getInt("jsal") < jobInfo.getJsal()){
					change.setCop("岗位变更，加薪");
					change.setCold(positionMap.get(jobInfo.getJpid()));
					change.setCnew(positionMap.get(resultSet.getInt("jpid")));
				}
				else if (resultSet.getInt("jdid") == jobInfo.getJdid()&&
						resultSet.getInt("jpid") != jobInfo.getJpid()&&
						resultSet.getInt("jsal") > jobInfo.getJsal()){
					change.setCop("岗位变更，降薪");
					change.setCold(positionMap.get(jobInfo.getJpid()));
					change.setCnew(positionMap.get(resultSet.getInt("jpid")));
				}
				else if (resultSet.getInt("jdid") != jobInfo.getJdid()&&
						resultSet.getInt("jpid") != jobInfo.getJpid()&&
						resultSet.getInt("jsal") == jobInfo.getJsal()){
					change.setCop("部门变更，岗位变更");
					change.setCold(deptMap.get(jobInfo.getJdid())+","+positionMap.get(jobInfo.getJpid()));
					change.setCnew(deptMap.get(resultSet.getInt("jdid"))+","+positionMap.get(resultSet.getInt("jpid")));
				}
				else if (resultSet.getInt("jdid") != jobInfo.getJdid()&&
						resultSet.getInt("jpid") != jobInfo.getJpid()&&
						resultSet.getInt("jsal") < jobInfo.getJsal()){
					change.setCop("部门变更，岗位变更，加薪");
					change.setCold(deptMap.get(jobInfo.getJdid())+","+positionMap.get(jobInfo.getJpid()));
					change.setCnew(deptMap.get(resultSet.getInt("jdid"))+","+positionMap.get(resultSet.getInt("jpid")));
				}
				else if (resultSet.getInt("jdid") != jobInfo.getJdid()&&
						resultSet.getInt("jpid") != jobInfo.getJpid()&&
						resultSet.getInt("jsal") > jobInfo.getJsal()){
					change.setCop("部门变更，岗位变更，降薪");
					change.setCold(deptMap.get(jobInfo.getJdid())+","+positionMap.get(jobInfo.getJpid()));
					change.setCnew(deptMap.get(resultSet.getInt("jdid"))+","+positionMap.get(resultSet.getInt("jpid")));
				}
				changeDao.addChange(change);
			}
		}catch(Exception e){
			System.out.println("修改员工在职信息失败！"+e.getMessage());
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
	
	/**员工离职处理，
	 * 薪金jsal=-1为离职状态
	 * @param jobInfo
	 * @return
	 */
	public int quitJobInfo(JobInfo jobInfo){
		int affect = 0;
		String sql = "update jobInfo set jsal = -1  where jid =  ?  ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try{
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setObject(1, jobInfo.getJid());
			System.out.println("----------"+jobInfo.getJid()+"------------");
			affect = preparedStatement.executeUpdate();
		}catch(Exception e){
			System.out.println("修改员工在职信息失败！"+e.getMessage());
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
