package com.neusoft.jobchangemanage.dao;

import java.util.List;

//import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.jobchangemanage.domain.JobCh;

public interface JobChDao {
	
	/**
	 * ��ѯԱ����Ϣ
	 */
//	public abstract List<Employee> listEmp(Employee emp);
	/**
	 * �������Ա����λ��Ϣ
	 */
	public abstract void addJobCh(JobCh jobch);
	/**
	 * �ѵ�����λԱ����Ϣ��ѯ
	 */
	public abstract List<JobCh> listJobch(JobCh jobch);

}




