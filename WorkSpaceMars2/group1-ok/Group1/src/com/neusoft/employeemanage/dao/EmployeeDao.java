package com.neusoft.employeemanage.dao;

import java.util.List;

import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;

public interface EmployeeDao {

	/**
	 * 增加用户,给试用期传参数。
	 * 
	 * @param employee对象
	 */
	public abstract Employee addEmployee(Employee employee);
	
	
	
	/**
	 * 查查询条件查询员工：
	 * 查询条件包括：  员工编号：all.em_number
	 *         		员工姓名：all.em_name
	 *              部门编号：all.dept_number
	 *         		部门名称：all.dept_name
	 *         		部门调转类型：all.dept_chType
	 *              部门开始日期：all.dept_startDate
	 *              部门结束日期：all.dept_endDate
	 *              岗位名称：all.job_name
	 *              岗位调转类型：all.job_chType
	 *              岗位开始日期：all.job_startDate
	 *              岗位结束日期：all.job_endDate
	 * 查询符合条件的所有员工
	 * @return List<Employee>
	 */
	public abstract List<Employee> findAllEmployeeList(All all);
	
	/**
	 * 修改员工信息 中的保存
	 * @param Employee：employee对象
	 */
	
	public abstract void editEmployee(Employee employee);
	
	/**
	 * 根据用户id查询用户
	 * @param userId:用户id
	 * @return User对象
	 */
	public abstract Employee findEmployeeById (int em_number) ;
	
	
}
