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
	 * ���Ӹ�λ
	 * @return 
	 */

	public boolean addJob(Job job) {
		
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			JobDaoImpl jobDaoImpl = new JobDaoImpl(conn);
			//��ѯ�Ƿ��Ѿ�������ͬnumber���û���������ڣ����쳣
			if(jobDaoImpl.getJobSi(job.getJob_number())){
			          return false;
		}						
			//��������
			DBUtils.beginTransaction(conn);
			//����DAO���������ݿ��������
			jobDaoImpl.addJob(job);
			//�ύ
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			//�ع�����
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding user", e);
		} finally {
			//�ر����ݿ�����
			DBUtils.closeConnection(conn);
		}
		return true;
	}
	/**
	 * ɾ����λ
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
	 * �༭��λ
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
	 * ��ѯ����λ�µ�Ա����Ϣ
	 * @param job_number
	 * @return
	 */

//	public List<Employee> listEmp(int job_number) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	/**
	 * ��ѯ��λ��Ϣ
	 * @param job
	 * @return
	 */

	public List<Job> findJobList(JobForm job) {
		List<Job> jobList = null;
		Connection conn = null;
		try {
			//��ȡ���ݿ�����
			conn = DBUtils.getConnection();
			//ʵ����DAO����
			JobDaoImpl jobDaoImpl = new JobDaoImpl(conn);
			
//			System.out.println(job.getJob_number()+"job.getJob_number()");//***Y
			//����DAO����
			jobList = jobDaoImpl.listJob(job);
			
//			System.out.println(jobList.size()+"jobList.size()");//***Y
			
//			System.out.println(jobList.get(0).getJob_number());//***N

			return jobList;
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException("Error on finding user", e);
		} finally {
			//�ر����ݿ�����
			DBUtils.closeConnection(conn);
		}
				
	}
	/**
	 * ��ֵ���޸�ҳ��
	 * @param job
	 * @return
	 */
	
	public Job getJobByID(int job_number){
		// TODO Auto-generated method stub
		return null;
	}

}
