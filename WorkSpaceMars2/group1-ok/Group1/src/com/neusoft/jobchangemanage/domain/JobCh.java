package com.neusoft.jobchangemanage.domain;

import java.io.Serializable;
import java.sql.Date;

public class JobCh implements Serializable{
	//*员工编号
	private int emp_number;
	//*员工姓名
	private String emp_name;
	//*调转前的岗位编号
    private int job_before;
	//*调转后的岗位编号
	private int job_after;
	//*调转后的岗位名称
	private String job_chName;
	//*调转类型
	private String job_chType;
	//*调转原因
	private String job_chReason;
	//*调转日期
	private String job_chDate;
	//*备注
	private String job_chExtra;
	
	//*开始日期
	private Date job_startDate;
	//*结束日期
	private Date job_endDate;
	
	public int getEmp_number() {
		return emp_number;
	}
	public void setEmp_number(int emp_number) {
		this.emp_number = emp_number;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getJob_before() {
		return job_before;
	}
	public void setJob_before(int job_before) {
		this.job_before = job_before;
	}
	public int getJob_after() {
		return job_after;
	}
	public void setJob_after(int job_after) {
		this.job_after = job_after;
	}
	
	
	public String getJob_chName() {
		return job_chName;
	}
	public void setJob_chName(String job_chName) {
		this.job_chName = job_chName;
	}
	public String getJob_chType() {
		return job_chType;
	}
	public void setJob_chType(String job_chType) {
		this.job_chType = job_chType;
	}
	public String getJob_chReason() {
		return job_chReason;
	}
	public void setJob_chReason(String job_chReason) {
		this.job_chReason = job_chReason;
	}
	public String getJob_chDate() {
		return job_chDate;
	}
	public void setJob_chDate(String job_chDate) {
		this.job_chDate = job_chDate;
	}
	public String getJob_chExtra() {
		return job_chExtra;
	}
	public void setJob_chExtra(String job_chExtra) {
		this.job_chExtra = job_chExtra;
	}
	public Date getJob_startDate() {
		return job_startDate;
	}
	public void setJob_startDate(Date job_startDate) {
		this.job_startDate = job_startDate;
	}
	public Date getJob_endDate() {
		return job_endDate;
	}
	public void setJob_endDate(Date job_endDate) {
		this.job_endDate = job_endDate;
	}
	
	

	
}
