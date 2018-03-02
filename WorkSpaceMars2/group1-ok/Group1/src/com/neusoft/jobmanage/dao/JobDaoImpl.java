package com.neusoft.jobmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


//import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.jobmanage.domain.Job;
import com.neusoft.jobmanage.form.JobForm;

import devoid.frame.business.DBUtils;
import devoid.frame.business.DaoException;

public class JobDaoImpl implements JobDao{
	
	private Connection conn;
	
	public JobDaoImpl(Connection conn){
		this.conn=conn;
	}
	/**
	 * 增加岗位
	 */

	public void addJob(Job job) {
		
		String sql="insert into job(id,job_number,job_name,job_type,job_max) "+"values(job_id.nextval,?,?,?,?)";	
		
		PreparedStatement pstmt = null;
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, job.getJob_number());
			pstmt.setString(2, job.getJob_name());
			pstmt.setString(3, job.getJob_type());
			pstmt.setString(4, job.getJob_max());
//			if(job.getJob_max().equals("")&&job.getJob_max()!=null){
//				pstmt.setString(4, job.getJob_max());
//			}			
			pstmt.executeUpdate();
		} catch (SQLException e) {
		     throw new DaoException("Error on adding Domi", e);
	     } finally {
		     DBUtils.closeStatement(pstmt);
	     }
	}
	/**
	 * 删除岗位
	 */

	public void delJob(int job_number) {
		String sql = "update job set situation = ? where job_number = ?";
        PreparedStatement pstmt = null;
        try {
        	pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, 0);
			pstmt.setInt(2, job_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
		     throw new DaoException("Error on adding edit", e);
	     } finally {
		     DBUtils.closeStatement(pstmt);
	     }
		
	}
	/**
	 * 编辑岗位
	 */

	public void editJob(Job job) {
		String sql = "update job set job_name = ?,job_type = ?,job_max = ? where job_number = ?";
        PreparedStatement pstmt = null;
        try {
        	pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, job.getJob_name());
			pstmt.setString(2, job.getJob_type());
			pstmt.setString(3, job.getJob_max());
			pstmt.setInt(4, job.getJob_number());
			pstmt.executeUpdate();
		} catch (SQLException e) {
		     throw new DaoException("Error on adding edit", e);
	     } finally {
		     DBUtils.closeStatement(pstmt);
	     }

		
	}
	/**
	 * 查询岗位下的员工
	 */

//	public List<Employee> listEmp(int job_number) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	/**
	 * 查询所有岗位
	 */

	public List<Job> listJob(JobForm job) {
		int number=job.getJob_number();
		String name=job.getJob_name();
		String type=job.getJob_type();
		String sql = "select * from job where situation=1 ";
		if((name!=null&&!"".equals(name))||number!=0||(type!=null&&type!="")||(job.getJob_situation()==1)){
			if(name!=null&&name!=""){
				sql=sql+"and job_name='"+name+"'";
//				System.out.println(name+"=name");
			}
			if(number!=0){
				sql=sql+" and job_number="+number;
//		或        sql=sql+" and job_number="+Integer.toString(number);
			}	
			if(type!=null&&!type.equals("")&&!type.equals("不限")){
				sql=sql+" and job_type='"+type+"'";
//				System.out.println(type+"=type");
			}
//			*状态
			if(job.getJob_situation()==1){
				sql=sql+" and situation=1";
			}
		}else{
			sql = "select * from job where 1=2";
		}
		sql=sql+" order by job_number";
	    Statement pstmt = null;
	    List<Job> listJob=new ArrayList<Job>();
//	    System.out.println("a");//***执行到了
	    /*job.reset(mapping, request);应在Action中*/
	    try {
	    	pstmt = conn.createStatement();
		    ResultSet rs=pstmt.executeQuery(sql);
//		    System.out.println("b");//***执行到了
		    //System.out.println(rs.next());//***返回假
				while(rs.next()){
					Job jobs = new Job();
					jobs.setJob_number(rs.getInt("job_number"));
					jobs.setJob_name(rs.getString("job_name"));
					jobs.setJob_type(rs.getString("job_type"));
					jobs.setJob_max(rs.getString("job_max"));
					jobs.setJob_man(rs.getInt("job_man"));
					listJob.add(jobs);
//					System.out.println(jobs.getJob_number()+"jobs.getJob_number()");//***没执行到**Y
				}
				
				return listJob;
	     } catch (SQLException e) {
		     throw new DaoException("Error on adding Domi", e);
	     } finally {
		     DBUtils.closeStatement(pstmt);
	     }
	}
	/**
	 * 传表单
	 * @param job_number
	 * @return
	 */
	
	
	public Job getJobByID(int job_number){
		return null;
	}
	
	/**
	 * 增加岗位人数，emp调用
	 */

	public void addMan(int job_number) {
		String sql = "update job set job_man = job_man+1 where job_number = ?";
        PreparedStatement pstmt = null;
        try {
        	pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, job_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
		     throw new DaoException("Error on adding addMan", e);
	     } finally {
		     DBUtils.closeStatement(pstmt);
	     }
		
	}
	
	/**
	 * 验证数据库中某一岗位是否存在
	 */
	
	public boolean getJobSi(int job_number){
		String sql = "select count(id) countnum from job where job_number=?";
		PreparedStatement pstmt = null;
		ResultSet set = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, job_number);
			set = pstmt.executeQuery();
			set.next();
			
			if(set.getInt("countnum")>0){
				return true;
			}else{
				//System.out.println("2");
				return false;
			}		
		} catch (SQLException e) {
			throw new DaoException("Error on getting a job",e);
		}finally{
			DBUtils.closeStatement(pstmt);
		}
	}
	
}
