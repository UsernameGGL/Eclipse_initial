package com.neusoft.domimanage.form;

import java.sql.Date;
import java.util.List;

import com.neusoft.domimanage.domain.DomiBean;
import com.neusoft.employeemanage.domain.Employee;

import devoid.frame.web.BaseForm;

public class DomiForm extends BaseForm{
	
      private DomiBean domiBean=new DomiBean();
      
	  private List<DomiBean> list;
	  
	  private List<Employee> elist;
	  
	  private List<String> codeList;
	  
	  private Employee employee;
	  
	  
	public int getId() {
		return domiBean.getId();
	}
	public void setId(int id) {
		domiBean.setId(id);
	}
	
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<String> getCodeList() {
		return codeList;
	}
	public void setCodeList(List<String> codeList) {
		this.codeList = codeList;
	}
	//domiBean对象的get、set方法
	public DomiBean getDomiBean() {
		return domiBean;
	}
	public void setDomiBean(DomiBean domiBean) {
		this.domiBean = domiBean;
	}
	public List<DomiBean> getList() {
		return list;
	}
	public void setList(List<DomiBean> list) {
		this.list = list;
	}
	public int getDept_number() {
		return domiBean.getDept_number();
	}
	public void setDept_number(int dept_number) {
		domiBean.setDept_number(dept_number);
	}
	public String getDept_name() {
		return domiBean.getDept_name();
	}
	public void setDept_name(String dept_name) {
		domiBean.setDept_name(dept_name);
	}
	public String getEm_format() {
		return domiBean.getEm_format();
	}
	public void setEm_format(String em_format) {
		domiBean.setEm_format(em_format);
	}
	public int getEm_number() {
		return domiBean.getEm_number();
	}
	public void setEm_number(int em_number) {
		domiBean.setEm_number(em_number);
	}
	public String getEm_name() {
		return domiBean.getEm_name();
	}
	public void setEm_name(String em_name) {
		domiBean.setEm_name(em_name);
	}
	public String getJob_name() {
		return domiBean.getJob_name();
	}
	public void setJob_name(String job_name) {
		domiBean.setJob_name(job_name);
	}
	public int getJob_number() {
		return domiBean.getJob_number();
	}
	public void setJob_number(int job_number) {
		domiBean.setJob_number(job_number);
	}
	
	
	
	//
	public String getBegin_date() {
		Date a = domiBean.getBegin_date();
		if (a == null) {
			return null;
		} else {
			return a.toString();
		}	
	}
	public void setBegin_date(String begin_date) {
		Date date = null;
		if (begin_date != null && !"".equals(begin_date.trim())) {
			date = Date.valueOf(begin_date);
		}
		domiBean.setBegin_date(date);
	}
	public String getEnd_date() {
		Date a = domiBean.getEnd_date();
		if (a == null) {
			return null;
		} else {
			return a.toString();
		}
	}
	public void setEnd_date(String end_date) {
		Date date = null;
		if (end_date != null && !"".equals(end_date.trim())) {
			date = Date.valueOf(end_date);
		}
		domiBean.setBegin_date(date);
	}
	//
	
	public List<Employee> getElist() {
		return elist;
	}
	public void setElist(List<Employee> elist) {
		this.elist = elist;
	}
	
	
	
	public String getLz_extra() {
		return domiBean.getLz_extra();
	}
	public void setLz_extra(String lz_extra) {
		domiBean.setLz_extra(lz_extra);
	}
	public String getLz_go() {
		return domiBean.getLz_go();
	}
	public void setLz_go(String lz_go) {
		domiBean.setLz_go(lz_go);
	}
	public int getLz_type() {
		return domiBean.getLz_type();
	}
	public void setLz_type(int lz_type) {
		domiBean.setLz_type(lz_type);
	}
	public String getLz_date() {
		Date lz_date = domiBean.getLz_date();
		return lz_date.toString();
	}
	public void setLz_date(String lz_date) {
		Date date = null;
		date = Date.valueOf(lz_date);
		domiBean.setLz_date(date);
	}
	
}
