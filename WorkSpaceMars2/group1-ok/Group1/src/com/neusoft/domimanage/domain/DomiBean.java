package com.neusoft.domimanage.domain;

import java.sql.Date;

public class DomiBean {
	/**
	 * 封装DomiBean对象的属性
	 */
	//部门编号
	 private int dept_number;
	 //部门名字
     private String dept_name;
   //用工形式
     private String em_format;
   //员工编号
     private int em_number;
   //员工名字
     private String em_name;
   //岗位编号
     private int job_number;
   //岗位名字
     private String job_name;
   //开始日期
     private Date begin_date;
   //结束日期
     private Date end_date;
  
    //id
     private int id;
     //备注
     private String lz_extra;
     //离职去向
     private String lz_go;
     //离职类型
     private int lz_type;
     //离职日期
     private Date lz_date;
     
     
	public String getLz_extra() {
		return lz_extra;
	}
	public void setLz_extra(String lz_extra) {
		this.lz_extra = lz_extra;
	}
	public String getLz_go() {
		return lz_go;
	}
	public void setLz_go(String lz_go) {
		this.lz_go = lz_go;
	}
	public int getLz_type() {
		return lz_type;
	}
	public void setLz_type(int lz_type) {
		this.lz_type = lz_type;
	}
	public Date getLz_date() {
		return lz_date;
	}
	public void setLz_date(Date lz_date) {
		this.lz_date = lz_date;
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
	public String getEm_format() {
		return em_format;
	}
	public void setEm_format(String em_format) {
		this.em_format = em_format;
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
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public Date getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getJob_number() {
		return job_number;
	}
	public void setJob_number(int job_number) {
		this.job_number = job_number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
     
	
}
