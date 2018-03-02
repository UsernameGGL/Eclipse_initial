package com.neusoft.jobmanage.domain;

import java.io.Serializable;

/**
 * 岗位实体类
 * @author ttc
 *
 */
//Serializable,就是java提供的通用数据保存和读取的接口。至于从什么地方读出来和保存到哪里去都被隐藏在函数参数的背后了
public class Job implements Serializable{
//	*岗位编号
	private int job_number;
//	*岗位名称
	private String job_name;
//	*岗位类型
	private String job_type;
//	*岗位编制
	private String job_max;
//	*在岗人数
	private int job_man;
//	*岗位状态
	private int job_situation;
	
	public int getJob_number() {
		return job_number;
	}
	public void setJob_number(int job_number) {
		this.job_number = job_number;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_type() {
		return job_type;
	}
	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	
	public String getJob_max() {
		return job_max;
	}
	public void setJob_max(String job_max) {
		this.job_max = job_max;
	}
	public int getJob_man() {
		return job_man;
	}
	public void setJob_man(int job_man) {
		this.job_man = job_man;
	}
	public int getJob_situation() {
		return job_situation;
	}
	public void setJob_situation(int job_situation) {
		this.job_situation = job_situation;
	}	
	
}
