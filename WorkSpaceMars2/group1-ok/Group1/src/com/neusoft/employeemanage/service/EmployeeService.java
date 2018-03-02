package com.neusoft.employeemanage.service;

import java.sql.Connection;
import java.util.List;
import com.neusoft.employeemanage.dao.EmployeeDaoImpl;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;

import devoid.frame.business.DBUtils;
import devoid.frame.business.ServiceException;

/**
 * ��Ա��������Ĳ�Ĺ�����,���õ���ģʽʵ��
 */
public class EmployeeService {

	private static EmployeeService instance = new EmployeeService();

	public static EmployeeService getInstance() {
		return instance;
	}

	private EmployeeService() {
	}

	/**
	 * ��Ա��ʵ��¼��
	 * 
	 * @param employee
	 */
	public Employee addEmployee(Employee employee) {
		
		Connection conn = null;
		try {
			// ��ȡ���ݿ�����
			conn = DBUtils.getConnection();
			// ʵ����DAO����
			EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(conn);
//		// ��ѯ�Ƿ��Ѿ�������ͬID���û���������ڣ����쳣
//		 if(employeeDao.findEmployeeByEm_number(employee.getEm_number())){
//			throw new RuntimeException("�ظ���Ա����ţ�"+employee.getEm_number());
//		 }
		 
			
			// ��������
			DBUtils.beginTransaction(conn);
			// ����DAO���������ݿ��������
			Employee e=employeeDao.addEmployee(employee);
			
			// �ύ
			DBUtils.commit(conn);
			return e;
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			// �ع�����
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding employee", e);
		} finally {
			// �ر����ݿ�����
			DBUtils.closeConnection(conn);
		}
	      
	}


	/**
	 * Ա����Ϣ�޸�
	 * 
	 * @param employee
	 */
	public void editEmployee(Employee employee) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(conn);
			// ��������
			DBUtils.beginTransaction(conn);
			employeeDao.editEmployee(employee);
			// �ύ
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("Error on editing employee", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	 }
	
	
	/**
	 * ��Ա����Ϣ�Ĳ�ѯ
	 * 
	 * @param employee
	 * @return
	 */
	
	public List<Employee> listEmployeeByCondition(All all) {
		List<Employee> employeeList = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			
			EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(conn);
			
            employeeList = employeeDao.findAllEmployeeList(all);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException("Error on finding employee", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return employeeList;
	}
	
	/**
	 * �����û�id��ѯ�Ñ���Ϣ
	 * @param id �û�ID
	 * @return employee����
	 */
	public Employee findEmployeeById(int id) {
		Employee employee = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(conn);

			employee = employeeDao.findEmployeeById(id);

		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("Error on getting user", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return employee;
	}
	/**
	 * ��֤Ա������Ƿ��ظ� 
	 * 
	 * 
	 * 
	 */
	public Boolean findEmployeeByEm_number(int em_number) {
		Connection conn = null;
		try {
		
			conn = DBUtils.getConnection();
			EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(conn);
		// ��ѯ�Ƿ��Ѿ�������ͬID���û���������ڣ����쳣
		if(employeeDao.findEmployeeByEm_number(em_number)){
			return true;
//			throw new RuntimeException("�ظ���Ա����ţ�"+employee.getEm_number());
		   }
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("Error on getting employee", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return false;
	}
}