package com.neusoft.probmanage.dao;

import java.util.List;


import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.probmanage.domain.ProbationBean;

public interface ProbationDao {
	/**
	 * 接收员工中心的有试用期的员工的信息并将信息保存到试用期表中
	 * @param employee
	 */
	 public abstract void addProbation(Employee employee);
	/**
	 * 试用期员工查询
	 * @param Probation
	 * @return
	 */
	public abstract List<All> findProbationList(All all) ;
   
	/**
	 * 已经转正员工查询
	 * @return
	 */	
	public abstract List<ProbationBean> findProbationedList(All all) ;
	
	/**
	 * 保存试用期员工的信息
	 */
	public abstract void editProbation(ProbationBean probationBean) ;
	
}
