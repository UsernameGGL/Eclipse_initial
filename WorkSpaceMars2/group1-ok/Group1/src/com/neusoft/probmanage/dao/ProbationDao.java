package com.neusoft.probmanage.dao;

import java.util.List;


import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
import com.neusoft.probmanage.domain.ProbationBean;

public interface ProbationDao {
	/**
	 * ����Ա�����ĵ��������ڵ�Ա������Ϣ������Ϣ���浽�����ڱ���
	 * @param employee
	 */
	 public abstract void addProbation(Employee employee);
	/**
	 * ������Ա����ѯ
	 * @param Probation
	 * @return
	 */
	public abstract List<All> findProbationList(All all) ;
   
	/**
	 * �Ѿ�ת��Ա����ѯ
	 * @return
	 */	
	public abstract List<ProbationBean> findProbationedList(All all) ;
	
	/**
	 * ����������Ա������Ϣ
	 */
	public abstract void editProbation(ProbationBean probationBean) ;
	
}
