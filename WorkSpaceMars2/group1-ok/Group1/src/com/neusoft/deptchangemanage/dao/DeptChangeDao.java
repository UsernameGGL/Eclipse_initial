package com.neusoft.deptchangemanage.dao;

import java.util.List;

import com.neusoft.deptchangemanage.domain.DeptChange;
import com.neusoft.deptchangemanage.form.DeptChangeForm;
import com.neusoft.deptmanage.domain.Dept;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
/**
 * 接口，定义了对数据库操作的员工调动的相关方法
 * @author Clover
 *
 */
public interface DeptChangeDao {
		
	/**
	 *当进入部门调动管理>>员工信息查询>>确认员工部门页面，点击保存时调用该方法，实现对员工部门的调动
	 */
	public abstract void addDeptChange(DeptChange deptchange);
	
	
	/**
	 * 当进入部门调动管理>>已调动部门员工信息查询页面，点击查询时调用该方法，实现数据库中以调动部门员工的查询
	 * @return
	 */
	public abstract List<DeptChange> listDeptChange(All all);
	//public abstract List<DeptChange> listDeptChange(DeptChange deptChange);
	/**
	 * 获得部门部门表中的部门编号和部门名称
	 */
	public abstract List<Dept> getDept_Name();
}
