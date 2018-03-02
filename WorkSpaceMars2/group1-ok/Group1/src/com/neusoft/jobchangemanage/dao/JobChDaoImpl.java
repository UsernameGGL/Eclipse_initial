
package com.neusoft.jobchangemanage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.jobchangemanage.domain.JobCh;
import com.neusoft.jobmanage.domain.Job;

import devoid.frame.business.DBUtils;
import devoid.frame.business.DaoException;

public class JobChDaoImpl implements JobChDao{
	/**
	 * 保存调动员工岗位信息
	 */
	private Connection conn;
	
	public JobChDaoImpl(Connection conn){//曾经忘写了
		this.conn=conn;
	}

	public void addJobCh(JobCh jobCh) {
		String sql="insert into job_ch(emp_number,emp_name,job_chname,job_chreason,job_chtype,job_chdate,job_chextra) "
			+"values(?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?)";	
		String updatesql = "update employee set job_number=(select job_number from job where job_name=?) where em_number=?";
		PreparedStatement pstmt = null;
		try {
//			pstmt = conn.prepareStatement("INSERT INTO job_ch(emp_number,emp_name,job_chname,job_chreason,job_chtype,job_chdate,job_chextra) "+
//					"VALUES(1,'a','b','c','d',to_date('1998-07-06','yyyy-mm-dd'),'e')");//aql语句后不能加分号
			/******调动之前的岗位人数减一********/
			pstmt = conn.prepareStatement("update job set job_man=(job_man-1) where job_number=(select job_number from employee where em_number=?)");
			pstmt.setLong(1,jobCh.getEmp_number());
			pstmt.executeUpdate();
			/*****调动之后的岗位人数加一********/	
			pstmt = conn.prepareStatement("update job set job_man=job_man+1 where job_name=?");
			pstmt.setString(1,jobCh.getJob_chName());
			pstmt.executeUpdate();
			/********向job_ch添加新数据*********/
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,jobCh.getEmp_number());
			pstmt.setString(2,jobCh.getEmp_name());
			pstmt.setString(3,jobCh.getJob_chName());
			pstmt.setString(4,jobCh.getJob_chReason());
			pstmt.setString(5,jobCh.getJob_chType());
			pstmt.setString(6,jobCh.getJob_chDate());
			pstmt.setString(7,jobCh.getJob_chExtra());		
			pstmt.executeUpdate();
			/********更新员工表中的数据*********/
			pstmt = conn.prepareStatement(updatesql);
			pstmt.setString(1, jobCh.getJob_chName());
			pstmt.setInt(2, jobCh.getEmp_number());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
		     throw new DaoException("Error on adding addJobCh", e);
	     } finally {
		     DBUtils.closeStatement(pstmt);
	     }
		
	}
	/**
	 * 查询员工信息
	 */

	/*public List<Employee> listEmp(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	/**
	 * 已调动岗位员工信息查询
	 */

	public List<JobCh> listJobch(JobCh jobCh) {
		Date startDate = jobCh.getJob_startDate();
		Date endDate = jobCh.getJob_endDate();
		int emp_number = jobCh.getEmp_number();
		String emp_name = jobCh.getEmp_name();
		String job_chType = jobCh.getJob_chType();
		String sql = "select * from job_ch where 1=1 ";
//		if(startDate!=null||endDate!=null||emp_number!=0||!"".equals(emp_name)||!"".equals(job_chType)){
			if(startDate!=null){
				sql=sql+" and to_date('"+startDate+"','yyyy-mm-dd')<=job_chdate";
			}
//			if(startDate!=null){
//				sql=sql+" and "+startDate+"<=job_chdate";
//			}	
			if(endDate!=null){
				sql=sql+" and to_date('"+endDate+"','yyyy-mm-dd')>=job_chdate";
			}
			
			if(emp_number>0){
				sql=sql+" and emp_number="+emp_number;
			}
			if(!"".equals(emp_name)){
				sql=sql+" and emp_name='"+emp_name+"'";
			}
			if(!"".equals(job_chType)){
				sql=sql+" and job_chtype='"+job_chType+"'";
			}
//		}else{
//			sql = "select * from job where 1=2";
//		}
		sql=sql+" order by job_chdate";
	    Statement pstmt = null;
	    List<JobCh> listJobCh=new ArrayList<JobCh>();
	    try {
	    	pstmt = conn.createStatement();
		    ResultSet rs=pstmt.executeQuery(sql);
				while(rs.next()){
					JobCh jobs = new JobCh();
					jobs.setEmp_number(rs.getInt("emp_number"));
					jobs.setEmp_name(rs.getString("emp_name"));
					jobs.setJob_chName(rs.getString("job_chname"));
					jobs.setJob_chReason(rs.getString("job_chreason"));
					jobs.setJob_chType(rs.getString("job_chtype"));
					jobs.setJob_chDate(rs.getDate("job_chdate").toString());
					jobs.setJob_chExtra(rs.getString("job_chextra"));
					listJobCh.add(jobs);
				}			
				return listJobCh;
	     } catch (SQLException e) {
		     throw new DaoException("Error on adding JobChDaoImpl", e);
	     } finally {
		     DBUtils.closeStatement(pstmt);
	     }
	}
	
	public List<Job> getJob_name(){
		String sql = "select  job_name ,job_number from job where situation<>0";
		Statement stmt = null;
		ResultSet set = null;
		List<Job> job_nameList = new ArrayList<Job>();
		try {
			stmt = conn.createStatement();
			set = stmt.executeQuery(sql);
			while(set.next()){
				Job job = new Job();
				job.setJob_name(set.getString("job_name"));
				job.setJob_number(set.getInt("job_number"));
				job_nameList.add(job);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on getting job_name",e);
		}finally{
			DBUtils.closeStatement(stmt);
		}
		return job_nameList;
	}
	
}
