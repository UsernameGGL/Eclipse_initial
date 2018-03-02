package com.neusoft.deptchangemanage.form;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.neusoft.constant.Constant;
import com.neusoft.deptchangemanage.domain.DeptChange;
import com.neusoft.employeemanage.domain.Employee;

import devoid.frame.web.BaseForm;

public class DeptChangeForm extends BaseForm {

	private DeptChange deptChange = new DeptChange();
	
	private List<DeptChange> deptChangeList;
	
	private List<Employee> employeeList;
	
	private List<String> codeList;
	
	
	

	public DeptChange getDeptChange() {
		return deptChange;
	}

	public void setDeptChange(DeptChange deptChange) {
		this.deptChange = deptChange;
	}
	
	public List<DeptChange> getDeptChangeList() {
		return deptChangeList;
	}

	public void setDeptChangeList(List<DeptChange> deptChangeList) {
		this.deptChangeList = deptChangeList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<String> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<String> codeList) {
		this.codeList = codeList;
	}
	public int getId() {
		return deptChange.getId();
	}
	public void setId(int id) {
		deptChange.setId(id);
	}
	public int getEm_id() {
		return deptChange.getEm_id();
	}
	public void setEm_id(int em_id) {
		deptChange.getEm_id();
	}
	public int getDept_number() {
		return deptChange.getDept_number();
	}

	public void setDept_number(int dept_number) {
		deptChange.setDept_number(dept_number);
	}

	public int getDept_after() {
		return deptChange.getDept_after();
	}

	public void setDept_after(int dept_after) {
		deptChange.setDept_after(dept_after);
	}

	public int getDept_chType() {
		return deptChange.getDept_chType();
	}

	public void setDept_chType(int dept_chType) {
		deptChange.setDept_chType(dept_chType);
	}

	public String getDept_chReason() {
		return deptChange.getDept_chReason();
	}

	public void setDept_chReason(String dept_chReason) {
		deptChange.setDept_chReason(dept_chReason);
	}

	public Date getDept_chDate() {
		return deptChange.getDept_chDate();
	}

	public void setDept_chDate(Date dept_chDate) {
		deptChange.setDept_chDate(dept_chDate);
	}

	public String getDept_chExtra() {
		return deptChange.getDept_chExtra();
	}

	public void setDept_chExtra(String dept_chExtra) {
		deptChange.setDept_chExtra(dept_chExtra);
	}
	public String getDept_startDate() {
		return deptChange.getDept_startDate();
	}

	public void setDept_startDate(String dept_startDate) {
		deptChange.setDept_startDate(dept_startDate);
	}

	public String getDept_endDate() {
		return deptChange.getDept_endDate();
	}

	public void setDept_endDate(String dept_endDate) {
		deptChange.setDept_endDate(dept_endDate);
	}
	public int getEm_number() {
		return deptChange.getEm_number();
	}
	public void setEm_number(int em_number) {
		deptChange.setEm_number(em_number);
	}
	
	public String getEm_name() {
		return deptChange.getEm_name();
	}
	public void setEm_name(String em_name) {
		deptChange.setEm_name(em_name);
	}
	

}
