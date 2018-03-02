package com.neusoft.jobchangemanage.dao;

import java.util.List;

//import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.jobchangemanage.domain.JobCh;

public interface JobChDao {
	
	/**
	 * 查询员工信息
	 */
//	public abstract List<Employee> listEmp(Employee emp);
	/**
	 * 保存调动员工岗位信息
	 */
	public abstract void addJobCh(JobCh jobch);
	/**
	 * 已调动岗位员工信息查询
	 */
	public abstract List<JobCh> listJobch(JobCh jobch);

}




