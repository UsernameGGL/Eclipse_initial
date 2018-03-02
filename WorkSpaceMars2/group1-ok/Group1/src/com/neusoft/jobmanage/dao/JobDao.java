package com.neusoft.jobmanage.dao;

import java.util.List;

//import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.jobmanage.domain.Job;
import com.neusoft.jobmanage.form.JobForm;

public interface JobDao {
	
	/**
	 * ���Ӹ�λ
	 */
	public abstract void addJob(Job job);
	/**
	 * ɾ����λ
	 */
	public abstract void delJob(int job_number);
	/**
	 * �޸ĸ�λ
	 */
	public abstract void editJob(Job job);
	/**
	 * ��ѯ���и�λ
	 */
	public abstract List<Job> listJob(JobForm job);
	/**
	 * ��ѯ��λ�µ�Ա��
	 */
//	public abstract List<Employee> listEmp(int job_number);
	
	/**
	 * ����
	 */
	public Job getJobByID(int job_number);

}
