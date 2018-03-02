package com.neusoft.jobchangemanage.form;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.neusoft.jobchangemanage.domain.JobCh;

import devoid.frame.web.BaseForm;

public class JobChForm extends BaseForm {
	
	private JobCh jobCh=new JobCh();
	
	private List<JobCh> list;

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		if(jobCh!=null){
			jobCh.setJob_after(0);
			jobCh.setJob_before(0);
			jobCh.setJob_chDate(null);
			jobCh.setJob_chType(null);
			jobCh.setJob_chReason(null);
			jobCh.setJob_chExtra(null);
			jobCh.setJob_startDate(null);
			jobCh.setJob_endDate(null);
		}
	}

	public List<JobCh> getList() {
		return list;
	}


	public void setList(List<JobCh> list) {
		this.list = list;
	}
	

	public int getEmp_number() {
		return jobCh.getEmp_number();
	}


	public void setEmp_number(int emp_number) {
		jobCh.setEmp_number(emp_number);
	}


	public String getEmp_name() {
		return jobCh.getEmp_name();
	}


	public void setEmp_name(String emp_name) {
		jobCh.setEmp_name(emp_name);
	}


	public int getJob_Before() {
		return jobCh.getJob_before();
	}


	public void setJob_before(int job_before) {
		jobCh.setJob_before(job_before);
	}


	public int getJob_after() {
		return jobCh.getJob_after();
	}


	public void setJob_after(int job_after) {
		jobCh.setJob_after(job_after);
	}


	public String getJob_chName() {
		return jobCh.getJob_chName();
	}


	public void setJob_chName(String job_chName) {
		jobCh.setJob_chName(job_chName);
	}


	public String getJob_chType() {
		return jobCh.getJob_chType();
	}


	public void setJob_chType(String job_chType) {
		jobCh.setJob_chType(job_chType);
	}


	public String getJob_chReason() {
		return jobCh.getJob_chReason();
	}


	public void setJob_chReason(String job_chReason) {
		jobCh.setJob_chReason(job_chReason);
	}


	public String getJob_chDate() {
		return jobCh.getJob_chDate();
	}


	public void setJob_chDate(String job_chDate) {
		jobCh.setJob_chDate(job_chDate);
	}


	public String getJob_chExtra() {
		return jobCh.getJob_chExtra();
	}


	public void setJob_chExtra(String job_chExtra) {
		jobCh.setJob_chExtra(job_chExtra);
	}



	public JobCh getJobCh() {
		return jobCh;
	}


	public void setJobCh(JobCh jobCh) {
		this.jobCh = jobCh;
	}


	public String getJob_startDate() {
		Date date = jobCh.getJob_startDate();
		if(date==null){
			return null;
		}else{
			return date.toString();
		}
	}


	public void setJob_startDate(String job_startDate) {
		Date startDate = null;
		if (job_startDate != null && !"".equals(job_startDate)) {
			startDate = Date.valueOf(job_startDate);
		}
		jobCh.setJob_startDate(startDate);
	}


	public String getJob_endDate() {
		Date date = jobCh.getJob_endDate();
		if(date==null){
			return null;
		}else{
			return date.toString();
		}
		
	}


	public void setJob_endDate(String job_endDate) {
		Date endDate = null;
		if (job_endDate != null && !"".equals(job_endDate)) {
			endDate = Date.valueOf(job_endDate);
		}
		jobCh.setJob_endDate(endDate);
	}
	
	

}
