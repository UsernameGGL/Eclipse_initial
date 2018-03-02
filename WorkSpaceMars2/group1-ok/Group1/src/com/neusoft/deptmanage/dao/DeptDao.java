package com.neusoft.deptmanage.dao;


import java.util.List;

import com.neusoft.deptmanage.domain.Dept;
import com.neusoft.employeemanage.domain.Employee;

/**
 *   定义了对数据库操作的部门增删改查及部门下员工查询的方法
 * @author Clover
 *
 */
public interface DeptDao {


    /**
     * 向数据库中增加部门的方法
     * @param dept
     */

	public abstract void addDept(Dept dept);

	/**
     * 查询数据库中部门信息的方法
     * @param dept_Number
     * @return
     */

	public abstract List<Dept> listDept(Dept dept);
	/**
	 * 查询某一个部门的信息
	 * @param dept_Number
	 * @return
	 */
	public Dept getDeptById(int dept_number);
    /**
     * 对数据库中的某个部门进行修改
     * @param dept
     */
	public abstract void editDept(Dept dept);
	
    /**
     * 删除数据库中部门的方法
     * @param dept_Number
     */
	public abstract void delDept(int dept_number);
    
//    /**
//     * 查询数据库中部门下员工方法
//     * @return
//     */
//	public abstract List<Employee> listAllDeptEmpl(int dept_number);
	/**
	 * 验证数据库中是否已存在某个部门
	 * @param dept_number
	 * @return
	 */
	public abstract boolean getDept(int dept_number);


}
