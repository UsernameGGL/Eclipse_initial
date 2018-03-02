package com.neusoft.deptchangemanage.domain;

import java.io.Serializable;
import java.sql.Date;

import com.neusoft.employeemanage.domain.Employee;

public class DeptChange implements Serializable {
	//员工表虚拟主键
	private int id;
	//员工编号
	private int em_number;
	//员工姓名
	private String em_name;
	//deptchange表中虚拟员工编号 
	private int em_id;
	//原部门编号
	private int dept_number;
	//原部门名称
	private String dept_oldName;
	//新部门编号
	private int dept_after;
	//新部门名称
	private String dept_newName;
	//调转类型
	private int dept_chType;
	//调转类型名称
	private String  dept_chValue;
	//调转原因
	private String dept_chReason;
	//调转日期
	private Date dept_chDate;
	//备注
	private String dept_chExtra;
	//开始查询日期
	private String dept_startDate;
	//结束查询日期
	private String dept_endDate;
	
    private Employee employee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEm_id() {
		return em_id;
	}
	public void setEm_id(int em_id) {
		this.em_id = em_id;
	}
	public int getEm_number() {
		return em_number;
	}
	public void setEm_number(int em_number) {
		this.em_number = em_number;
	}
	
	public String getEm_name() {
		return em_name;
	}
	public void setEm_name(String em_name) {
		this.em_name = em_name;
	}
	
	public int getDept_after() {
		return dept_after;
	}
	public void setDept_after(int dept_after) {
		this.dept_after = dept_after;
	}
	public int getDept_chType() {
		return dept_chType;
	}
	public void setDept_chType(int dept_chType) {
		this.dept_chType = dept_chType;
	}
	public String getDept_chReason() {
		return dept_chReason;
	}
	public void setDept_chReason(String dept_chReason) {
		this.dept_chReason = dept_chReason;
	}
	public Date getDept_chDate() {
		return dept_chDate;
	}
	public void setDept_chDate(Date dept_chDate) {
		this.dept_chDate = dept_chDate;
	}
	public String getDept_chExtra() {
		return dept_chExtra;
	}
	public void setDept_chExtra(String dept_chExtra) {
		this.dept_chExtra = dept_chExtra;
	}
	public String getDept_startDate() {
		return dept_startDate;
	}
	public void setDept_startDate(String dept_startDate) {
		this.dept_startDate = dept_startDate;
	}
	public String getDept_endDate() {
		return dept_endDate;
	}
	public void setDept_endDate(String dept_endDate) {
		this.dept_endDate = dept_endDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getDept_number() {
		return dept_number;
	}
	public void setDept_number(int dept_number) {
		this.dept_number = dept_number;
	}
	public String getDept_oldName() {
		return dept_oldName;
	}
	public void setDept_oldName(String dept_oldName) {
		this.dept_oldName = dept_oldName;
	}
	public String getDept_newName() {
		return dept_newName;
	}
	public void setDept_newName(String dept_newName) {
		this.dept_newName = dept_newName;
	}
	public String getDept_chValue() {
		return dept_chValue;
	}
	public void setDept_chValue(String dept_chValue) {
		this.dept_chValue = dept_chValue;
	}
	
}
