package com.neusoft.jobchangemanage.service;

import java.sql.Connection;
import java.util.List;

//import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.jobchangemanage.dao.JobChDaoImpl;
import com.neusoft.jobchangemanage.domain.JobCh;

import com.neusoft.jobmanage.domain.Job;

import devoid.frame.business.DBUtils;
import devoid.frame.business.ServiceException;

public class JobChService {
	
private static JobChService instence = new JobChService();
	
	public static JobChService getInstance() {
		return instence;
	}
	/**
	 * ��Ա���ĸ�λ�����������б���
	 * @param jobch
	 */
	
	public void addJobCh(JobCh jobCh) {
		Connection conn = null;		
		try {
			conn = DBUtils.getConnection();
			JobChDaoImpl jobChDaoImpl = new JobChDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			jobChDaoImpl.addJobCh(jobCh);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding jobChService", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		
	}
	/**
	 * ��ѯԱ��
	 * @param emp
	 * @return
	 */
	public List<Job> getJob_name(){
		Connection conn = null;
		List<Job> job_nameList = null;
		try{
			//��ȡ���ݿ�����
			conn = DBUtils.getConnection();
			//����dao�����
			JobChDaoImpl jobChDaoImpl = new JobChDaoImpl(conn);
			//����dao�㷽��
			job_nameList = jobChDaoImpl.getJob_name();
			
		}catch(ServiceException s){
			throw s;
		}catch(Exception e){
			throw new ServiceException("Error on getting job_name",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return job_nameList;
}
	/**
	 * ��λ������'��'ֵ�Ļ�ȡ
	 * @param jobch
	 * @return
	 */

	public List<JobCh> listJobch(JobCh jobCh) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * �ѵ�����λԱ����Ϣ��ѯ
	 * @param empl
	 * @return
	 */

	public List<JobCh> listDetailEmpl(JobCh jobCh){
		List<JobCh> jobChList = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			JobChDaoImpl jobChDaoImpl = new JobChDaoImpl(conn);
			jobChList = jobChDaoImpl.listJobch(jobCh);
			return jobChList;
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException("Error on finding jobchService", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}
	
}

