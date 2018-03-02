package com.neusoft.deptmanage.dao;


import java.util.List;

import com.neusoft.deptmanage.domain.Dept;
import com.neusoft.employeemanage.domain.Employee;

/**
 *   �����˶����ݿ�����Ĳ�����ɾ�Ĳ鼰������Ա����ѯ�ķ���
 * @author Clover
 *
 */
public interface DeptDao {


    /**
     * �����ݿ������Ӳ��ŵķ���
     * @param dept
     */

	public abstract void addDept(Dept dept);

	/**
     * ��ѯ���ݿ��в�����Ϣ�ķ���
     * @param dept_Number
     * @return
     */

	public abstract List<Dept> listDept(Dept dept);
	/**
	 * ��ѯĳһ�����ŵ���Ϣ
	 * @param dept_Number
	 * @return
	 */
	public Dept getDeptById(int dept_number);
    /**
     * �����ݿ��е�ĳ�����Ž����޸�
     * @param dept
     */
	public abstract void editDept(Dept dept);
	
    /**
     * ɾ�����ݿ��в��ŵķ���
     * @param dept_Number
     */
	public abstract void delDept(int dept_number);
    
//    /**
//     * ��ѯ���ݿ��в�����Ա������
//     * @return
//     */
//	public abstract List<Employee> listAllDeptEmpl(int dept_number);
	/**
	 * ��֤���ݿ����Ƿ��Ѵ���ĳ������
	 * @param dept_number
	 * @return
	 */
	public abstract boolean getDept(int dept_number);


}
