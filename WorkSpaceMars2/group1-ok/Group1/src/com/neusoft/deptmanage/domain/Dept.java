package com.neusoft.deptmanage.domain;

import java.io.Serializable;
import java.sql.Date;

public class Dept implements Serializable {
	private int id;
	//部门编号
	private int dept_number;
	//部门名称
	private String dept_name;
	//部门类型
	private int dept_type;
	//部门类型值
	private String dept_value;
	//电话
	private String dept_tel;
	//传真
	private String dept_fax;
	//上级部门编号  
	private int dept_super;
	//上级部门名称
	private String dept_superName;
	//描述
	private String dept_desc;
	//成立日期
	private Date dept_setDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDept_number() {
		return dept_number;
	}
	public void setDept_number(int dept_number) {
		this.dept_number = dept_number;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public int getDept_type() {
		return dept_type;
	}
	public void setDept_type(int dept_type) {
		this.dept_type = dept_type;
	}
	public String getDept_value() {
		return dept_value;
	}
	public void setDept_value(String dept_value) {
		this.dept_value = dept_value;
	}
	public String getDept_tel() {
		return dept_tel;
	}
	public void setDept_tel(String dept_tel) {
		this.dept_tel = dept_tel;
	}
	public String getDept_fax() {
		return dept_fax;
	}
	public void setDept_fax(String dept_fax) {
		this.dept_fax = dept_fax;
	}
	public int getDept_super() {
		return dept_super;
	}
	public void setDept_super(int dept_super) {
		this.dept_super = dept_super;
	}
	public String getDept_superName() {
		return dept_superName;
	}
	public void setDept_superName(String dept_superName) {
		this.dept_superName = dept_superName;
	}
	public String getDept_desc() {
		return dept_desc;
	}
	public void setDept_desc(String dept_desc) {
		this.dept_desc = dept_desc;
	}
	public Date getDept_setDate() {
		return dept_setDate;
	}
	public void setDept_setDate(Date dept_setDate) {
		this.dept_setDate = dept_setDate;
	}
	
}
