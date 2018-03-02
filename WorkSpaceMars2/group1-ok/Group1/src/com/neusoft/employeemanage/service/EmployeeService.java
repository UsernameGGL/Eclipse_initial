package com.neusoft.employeemanage.service;

import java.sql.Connection;
import java.util.List;
import com.neusoft.employeemanage.dao.EmployeeDaoImpl;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;

import devoid.frame.business.DBUtils;
import devoid.frame.business.ServiceException;

/**
 * 对员工完成增改查的管理类,采用单例模式实现
 */
public class EmployeeService {

	private static EmployeeService instance = new EmployeeService();

	public static EmployeeService getInstance() {
		return instance;
	}

	private EmployeeService() {
	}

	/**
	 * 对员工实现录入
	 * 
	 * @param employee
	 */
	public Employee addEmployee(Employee employee) {
		
		Connection conn = null;
		try {
			// 获取数据库连接
			conn = DBUtils.getConnection();
			// 实例化DAO对象
			EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(conn);
//		// 查询是否已经存在相同ID的用户，如果存在，抛异常
//		 if(employeeDao.findEmployeeByEm_number(employee.getEm_number())){
//			throw new RuntimeException("重复的员工编号："+employee.getEm_number());
//		 }
		 
			
			// 开启事务
			DBUtils.beginTransaction(conn);
			// 调用DAO方法向数据库插入数据
			Employee e=employeeDao.addEmployee(employee);
			
			// 提交
			DBUtils.commit(conn);
			return e;
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			// 回滚事务
			DBUtils.rollback(conn);
			throw new ServiceException("Error on adding employee", e);
		} finally {
			// 关闭数据库连接
			DBUtils.closeConnection(conn);
		}
	      
	}


	/**
	 * 员工信息修改
	 * 
	 * @param employee
	 */
	public void editEmployee(Employee employee) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(conn);
			// 开启事务
			DBUtils.beginTransaction(conn);
			employeeDao.editEmployee(employee);
			// 提交
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
	 * 对员工信息的查询
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
	 * 根据用户id查询用戶信息
	 * @param id 用户ID
	 * @return employee对象
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
	 * 验证员工编号是否重复 
	 * 
	 * 
	 * 
	 */
	public Boolean findEmployeeByEm_number(int em_number) {
		Connection conn = null;
		try {
		
			conn = DBUtils.getConnection();
			EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(conn);
		// 查询是否已经存在相同ID的用户，如果存在，抛异常
		if(employeeDao.findEmployeeByEm_number(em_number)){
			return true;
//			throw new RuntimeException("重复的员工编号："+employee.getEm_number());
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