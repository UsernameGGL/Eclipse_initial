package com.neusoft.employeemanage.dao;

import java.util.List;

import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;

public interface EmployeeDao {

	/**
	 * �����û�,�������ڴ�������
	 * 
	 * @param employee����
	 */
	public abstract Employee addEmployee(Employee employee);
	
	
	
	/**
	 * ���ѯ������ѯԱ����
	 * ��ѯ����������  Ա����ţ�all.em_number
	 *         		Ա��������all.em_name
	 *              ���ű�ţ�all.dept_number
	 *         		�������ƣ�all.dept_name
	 *         		���ŵ�ת���ͣ�all.dept_chType
	 *              ���ſ�ʼ���ڣ�all.dept_startDate
	 *              ���Ž������ڣ�all.dept_endDate
	 *              ��λ���ƣ�all.job_name
	 *              ��λ��ת���ͣ�all.job_chType
	 *              ��λ��ʼ���ڣ�all.job_startDate
	 *              ��λ�������ڣ�all.job_endDate
	 * ��ѯ��������������Ա��
	 * @return List<Employee>
	 */
	public abstract List<Employee> findAllEmployeeList(All all);
	
	/**
	 * �޸�Ա����Ϣ �еı���
	 * @param Employee��employee����
	 */
	
	public abstract void editEmployee(Employee employee);
	
	/**
	 * �����û�id��ѯ�û�
	 * @param userId:�û�id
	 * @return User����
	 */
	public abstract Employee findEmployeeById (int em_number) ;
	
	
}
