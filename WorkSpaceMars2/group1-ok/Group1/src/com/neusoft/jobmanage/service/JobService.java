package com.neusoft.jobmanage.service;

import java.sql.Connection;
import java.util.List;

//import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.jobmanage.dao.JobDaoImpl;
import com.neusoft.jobmanage.domain.Job;
import com.neusoft.jobmanage.form.JobForm;

import devoid.frame.business.DBUtils;
import devoid.frame.business.ServiceException;


public class JobService {
	
	private static JobService instance = new JobService();
	
	public static JobService getInstance() {
		return instance;
	}
	
	/**
	 * 增加岗位
	 * @return 
	 */

	public boolean addJob(Job job) {
		
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			JobDaoImpl jobDaoImpl = new JobDaoImpl(conn);
			//查询是否已经存在相同number的用户，如果存在，抛异常
			if(jobDaoImpl.getJobSi(job.getJob_number())){
			          return false;
		}						
			//开启事务
			DBUtils.beginTransaction(conn);
			//调用DAO方法向数据库插入数据
			jobDaoImpl.addJob(job);
			//提交
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			//回滚事务
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding user", e);
		} finally {
			//关闭数据库连接
			DBUtils.closeConnection(conn);
		}
		return true;
	}
	/**
	 * 删除岗位
	 */
	public void delJob(int job_number) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			JobDaoImpl jobDaoImpl = new JobDaoImpl(conn);					
			DBUtils.beginTransaction(conn);
			jobDaoImpl.delJob(job_number);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding job service", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		
	}
	/**
	 * 编辑岗位
	 */

	public void editJob(Job job) {
          Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			JobDaoImpl jobDaoImpl = new JobDaoImpl(conn);					
			DBUtils.beginTransaction(conn);
			jobDaoImpl.editJob(job);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding job service", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		
	}
	/**
	 * 查询本岗位下的员工信息
	 * @param job_number
	 * @return
	 */

//	public List<Employee> listEmp(int job_number) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	/**
	 * 查询岗位信息
	 * @param job
	 * @return
	 */

	public List<Job> findJobList(JobForm job) {
		List<Job> jobList = null;
		Connection conn = null;
		try {
			//获取数据库连接
			conn = DBUtils.getConnection();
			//实例化DAO对象
			JobDaoImpl jobDaoImpl = new JobDaoImpl(conn);
			
//			System.out.println(job.getJob_number()+"job.getJob_number()");//***Y
			//调用DAO方法
			jobList = jobDaoImpl.listJob(job);
			
//			System.out.println(jobList.size()+"jobList.size()");//***Y
			
//			System.out.println(jobList.get(0).getJob_number());//***N

			return jobList;
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException("Error on finding user", e);
		} finally {
			//关闭数据库连接
			DBUtils.closeConnection(conn);
		}
				
	}
	/**
	 * 传值到修改页面
	 * @param job
	 * @return
	 */
	
	public Job getJobByID(int job_number){
		// TODO Auto-generated method stub
		return null;
	}

}
