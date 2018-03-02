package com.neusoft.jobmanage.dao;

import java.util.List;

//import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.jobmanage.domain.Job;
import com.neusoft.jobmanage.form.JobForm;

public interface JobDao {
	
	/**
	 * 增加岗位
	 */
	public abstract void addJob(Job job);
	/**
	 * 删除岗位
	 */
	public abstract void delJob(int job_number);
	/**
	 * 修改岗位
	 */
	public abstract void editJob(Job job);
	/**
	 * 查询所有岗位
	 */
	public abstract List<Job> listJob(JobForm job);
	/**
	 * 查询岗位下的员工
	 */
//	public abstract List<Employee> listEmp(int job_number);
	
	/**
	 * 传表单
	 */
	public Job getJobByID(int job_number);

}
