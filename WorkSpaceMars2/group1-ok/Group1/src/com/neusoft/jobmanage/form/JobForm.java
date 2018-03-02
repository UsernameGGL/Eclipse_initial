package com.neusoft.jobmanage.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;



import com.neusoft.code.domain.Code;
import com.neusoft.jobmanage.domain.Job;

import devoid.frame.web.BaseForm;

public class JobForm extends BaseForm{	
	private Job job=new Job();
	private Code code = new Code();
	private List<Job> list;
	private List<Code> codeList;
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		if(job!=null){
			job.setJob_number(0);
			job.setJob_name(null);
			job.setJob_type(null);
			job.setJob_max(null);
		}
	}
	
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public List<Job> getList() {
		return list;
	}

	public void setList(List<Job> list) {
		this.list = list;
	}
	

	public List<Code> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<Code> codeList) {
		this.codeList = codeList;
	}

	public int getJob_number() {
		return job.getJob_number();
	}

	public void setJob_number(int job_number) {
		job.setJob_number(job_number);
	}

	public String getJob_name() {
		return job.getJob_name();
	}

	public void setJob_name(String job_name) {
		job.setJob_name(job_name);
	}

	public String getJob_type() {
		return job.getJob_type();
	}

	public void setJob_type(String job_type) {
		job.setJob_type(job_type);
	}

	public String getJob_max() {
		return job.getJob_max();
	}

	public void setJob_max(String job_max) {
		job.setJob_max(job_max);
	}

	public int getJob_man() {
		return job.getJob_man();
	}

	public void setJob_man(int job_man) {
		job.setJob_man(job_man);
	}

	public int getJob_situation() {
		return job.getJob_situation();
	}

	public void setJob_situation(int job_situation) {
		job.setJob_situation(job_situation);
	}

	public int getId() {
		return code.getId();
	}

	public void setId(int id) {
		code.setId(id);
	}

	public String getCode_value() {
		return code.getCode_value();
	}

	public void setCode_value(String value) {
		code.setCode_value(value);
	}
	
}
