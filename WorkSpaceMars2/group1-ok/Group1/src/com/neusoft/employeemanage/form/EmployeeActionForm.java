package com.neusoft.employeemanage.form;

import java.sql.Date;
import java.util.List;

import com.neusoft.employeemanage.domain.Employee;

import devoid.frame.web.BaseForm;

public class EmployeeActionForm extends BaseForm {


	/**
	 * 建立Employee ：employee 封装职工的信息
	 * 
	 */

	private Employee employee = new Employee();

	public Employee getEmployee() {
		return employee;
		
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	/**
	 * 下拉菜单获取文字
	 * @return
	 */
	private List<String> codeList;;
	private List<Employee> list;
	
	
	public List<String> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<String> codeList) {
		this.codeList = codeList;
	}

	
	
	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}
	
	
	//主键ID
	
	public int getId() {
		return employee.getId();
	}
	public void setId(int id) {
		employee.setId(id);
	}
	
	
	
	
	
	public int getEm_number() {
		return employee.getEm_number();
	}

	public void setEm_number(int em_number) {
		employee.setEm_number(em_number);
	}

	public String getEm_name() {
		return employee.getEm_name();
	}

	public void setEm_name(String em_name) {
		employee.setEm_name(em_name);
	}
//**********
	public String getEm_birth() {
		
		System.out.println("getEm_birth"+getEm_birth());
		Date birthDay = employee.getEm_birth();
		return birthDay.toString();
	}

	public void setEm_birth(String em_birth) {
		Date date = null;
		date = Date.valueOf(em_birth);
		employee.setEm_birth(date);
	}
//**********
	public int getSex() {
		return employee.getSex();
	}

	public void setSex(int sex) {
		employee.setSex(sex);
	}

	public int getEm_format() {
		return employee.getEm_format();
	}

	public void setEm_format(int em_format) {
		employee.setEm_format(em_format);
	}

	public int getEm_source() {
		return employee.getEm_source();
	}

	public void setEm_source(int em_source) {
		employee.setEm_source(em_source);
	}

	public int getEm_polity() {
		return employee.getEm_polity();
	}

	public void setEm_polity(int em_polity) {
		employee.setEm_polity(em_polity);
	}

	public int getEm_folk() {
		return employee.getEm_folk();
	}

	public void setEm_folk(int em_folk) {
		employee.setEm_folk(em_folk);
	}

	public String getEm_id() {
		return employee.getEm_id();
	}

	public void setEm_id(String em_id) {
		employee.setEm_id(em_id);
	}
//************
	public String getEm_indate() {
		Date indate = employee.getEm_indate();
		return indate.toString();
	}

	public void setEm_indate(String em_indate) {
		Date date = null;
		date = Date.valueOf(em_indate);
		employee.setEm_indate(date);
	}
//************
	public String getEm_worktime() {
		Date worktime = employee.getEm_worktime();
		return worktime.toString();
		
	}

	public void setEm_worktime(String em_worktime) {
		Date date = null;
		date = Date.valueOf(em_worktime);
		employee.setEm_worktime(date);
	}
//**********
	public String getEm_birthplace() {
		return employee.getEm_birthplace();
	}

	public void setEm_birthplace(String em_birthplace) {
		employee.setEm_birthplace(em_birthplace);
	}

	public String getEm_phone() {
		return employee.getEm_phone();
	}

	public void setEm_phone(String em_phone) {
		employee.setEm_phone(em_phone);
	}

	public String getEm_mail() {
		return employee.getEm_mail();
	}

	public void setEm_mail(String em_mail) {
		employee.setEm_mail(em_mail);
	}

	public int getEm_blood() {
		return employee.getEm_blood();
	}

	public void setEm_blood(int em_blood) {
		employee.setEm_blood(em_blood);
	}

	public int getEm_wedlock() {
		return employee.getEm_wedlock();
	}

	public void setEm_wedlock(int em_wedlock) {
		employee.setEm_wedlock(em_wedlock);
	}

	public String getEm_stature() {
		return employee.getEm_stature();
	}

	public void setEm_stature(String em_stature) {
		employee.setEm_stature(em_stature);
	}

	public int getDept_number() {
		return employee.getDept_number();
	}

	public void setDept_number(int dept_number) {
		employee.setDept_number(dept_number);
	}

	public int getJob_number() {
		return employee.getJob_number();
	}

	public void setJob_number(int job_number) {
		employee.setJob_number(job_number);
	}

	public String getEm_seat() {
		return employee.getEm_seat();
	}

	public void setEm_seat(String em_seat) {
		employee.setEm_seat(em_seat);
	}

	public int getEm_learn() {
		return employee.getEm_learn();
	}

	public void setEm_learn(int em_learn) {
		employee.setEm_learn(em_learn);
	}

	public int getEm_degree() {
		return employee.getEm_degree();
	}

	public void setEm_degree(int em_degree) {
		employee.setEm_degree(em_degree);
	}

	public String getEm_graduate() {
		return employee.getEm_graduate();
	}

	public void setEm_graduate(String em_graduate) {
		employee.setEm_graduate(em_graduate);
	}

	public String getEm_specialty() {
		return employee.getEm_specialty();
	}

	public void setEm_specialty(String em_specialty) {
		employee.setEm_specialty(em_specialty);
	}
//********
	public String getEm_gradate() {
		Date a = employee.getEm_gradate();
		if (a == null) {
			return null;
		} else {
			return a.toString();
		}	
	}

	public void setEm_gradate(String em_gradate) {
		Date date = null;
		if (em_gradate != null && !"".equals(em_gradate.trim())) {
			date = Date.valueOf(em_gradate);
		}
		employee.setEm_gradate(date);
	
	}
//********
	public String getEm_homeplace() {
		return employee.getEm_homeplace();
	}

	public void setEm_homeplace(String em_homeplace) {
		employee.setEm_homeplace(em_homeplace);
	}
//********
	public String getProb_start() {
		Date start = employee.getProb_start();
		if (start == null) {
			return null;
		} else {
			return start.toString();
		}	
	}

	public void setProb_start(String prob_start) {	
		Date date = null;
		if (prob_start != null && !"".equals(prob_start.trim())) {
			date = Date.valueOf(prob_start);
		}
		employee.setProb_start(date);
	}
//**********
	public String getProb_end() {	
		Date end = employee.getProb_end(); 
		if (end == null) {
			return null;
		} else {
			return end.toString();
		}
	}

	public void setProb_end(String prob_end) {
		Date date = null;
		if (prob_end != null && !"".equals(prob_end.trim())) {
			date = Date.valueOf(prob_end);
		}
		employee.setProb_end(date);
	}
//********	
	public int getSituation() {
		return employee.getSituation();
	}
	public void setSituation(int situation) {
		employee.setSituation(situation);
	}
//**************
	public String getDept_name() {
		return employee.getDept_name();
	}
	public void setDept_name(String dept_name) {
		employee.setDept_name(dept_name);
	}
	//*********************
	public String getJob_name() {
		return employee.getJob_name();
	}
	public void setJob_name(String job_name) {
		employee.setJob_name(job_name);
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
}
