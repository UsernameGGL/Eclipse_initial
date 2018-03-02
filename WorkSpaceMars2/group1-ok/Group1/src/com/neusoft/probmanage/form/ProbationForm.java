package com.neusoft.probmanage.form;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.neusoft.deptchangemanage.domain.DeptChange;
import com.neusoft.domimanage.domain.DomiBean;
import com.neusoft.employeemanage.domain.Employee;

import com.neusoft.probmanage.domain.ProbationBean;

import devoid.frame.web.BaseForm;

public class ProbationForm extends BaseForm{

	private ProbationBean probation=new ProbationBean();
	
	private List<Employee> employeeList;
	
	 private ArrayList<ProbationBean> probationlist;

	  //domiBean对象的get、set方法

	  
		private String[] id;
		
		
//		public String[] getId() {
//			return id;
//		}

		public void setId(String[] id) {
			this.id = id;
		}
		
		/**
		 * 下拉菜单获取文字
		 * @return
		 */
	private List<String> probationList;;
	private List<ProbationBean> list;
	
	
	public List<String> getProbationList() {
		return probationList;
	}
	
	public void setProbationList(List<String> probationList) {
		this.probationList = probationList;
	}
	
	
	
	public List<ProbationBean> getList() {
		return list;
	}
	
	public void setList(List<ProbationBean> list) {
		this.list = list;
	}
	
	
	public ProbationBean getProbation() {
		return probation;
	}
	
	public void setProbation(ProbationBean probation) {
		this.probation = probation;
	}
	
	public int getProb_status() {
		return probation.getProb_status();
	}
	public void setProb_status(int prob_status) {
		probation.setProb_status(prob_status);
	}
	public String getProb_start() {
		Date date = probation.getProb_start();
		if (date == null) {
			return null;
		} else {
			return date.toString();
		}
	}
	public void setProb_start(String prob_start) {
		Date date = null;
		if (prob_start != null && !"".equals(prob_start.trim())) {
			date = Date.valueOf(prob_start);
		}
		probation.setProb_start(date);
	}
	public String getProb_end() {
		Date date = probation.getProb_end();
		if (date == null) {
			return null;
		} else {
			return date.toString();
		}
	}
	public void setProb_end(String prob_end) {
		Date date = null;
		if (prob_end != null && !"".equals(prob_end.trim())) {
			date = Date.valueOf(prob_end);
		}
		probation.setProb_end(date);
	}
	public String getProb_reviews() {
		return probation.getProb_reviews();
	}
	public void setProb_reviews(String prob_reviews) {
		probation.setProb_reviews(prob_reviews);
	}
	public int getProb_results() {
		return probation.getProb_results();
	}
	public void setProb_results(int prob_results) {
		probation.setProb_results(prob_results);
	}
	/**************处理日期****************/
	public String getProb_date() {
		Date date =  probation.getProb_date();
		if(date==null){
			return null;
		}else{
			return date.toString();
		}
	}
	public void setProb_date(String prob_date) {
		Date date  = null;
		if(prob_date!=null&&!"".equals(prob_date.trim())){
			date = Date.valueOf(prob_date);
		}
		probation.setProb_date(date);
	}
	/**************备注****************/
	public String getProb_notes() {
		return probation.getProb_notes();
	}
	public void setProb_notes(String prob_notes) {
		probation.setProb_notes(prob_notes);
	}
	
	/**************岗位编号****************/
	public String getProb_jobId() {
		return probation.getProb_jobId();
	}
	public void setProb_jobId(String prob_jobId) {
		probation.setProb_jobId(prob_jobId);
	}
	/**************岗位名称****************/
	public String getProb_jobName() {
		return probation.getProb_jobName();
	}
	public void setProb_jobName(String prob_jobName) {
		probation.setProb_jobName(prob_jobName);
	}
	/**************部门名称****************/
	public String getProb_branchName() {
		return probation.getProb_branchName();
	}
	public void setProb_branchName(String prob_branchName) {
		probation.setProb_branchName(prob_branchName);
	}
	public String getProb_name() {
		return probation.getProb_name();
	}
	public void setProb_name(String prob_name) {
		probation.setProb_name(prob_name);
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	//虚拟的员工编号
	public int getId() {
		return probation.getId();
	}
	public void setId(int id) {
		probation.setId(id);
	}
	
//	//员工编号
//	public int getEm_number() {
//		return probation.getEm_number();
//	}
//	public void setEm_number(int em_number) {
//		probation.setEm_number(em_number);
//	}
//	//部门编号
//	public String getProb_branchId() {
//		return probation.getProb_branchId();
//	}
//	public void setProb_branchId(String prob_branchId) {
//		probation.setProb_branchId(prob_branchId);
//	}
	/****************延期到的时间*************/
	public String getExtend_date() {
		Date date =  probation.getExtend_date();
		if(date==null){
			return null;
		}else{
			return date.toString();
		}
	}
	public void setExtend_date(String extend_date) {
		Date date  = null;
		if(extend_date!=null&&!"".equals(extend_date.trim())){
			date = Date.valueOf(extend_date);
		}
		probation.setExtend_date(date);
		
	}
	
}
