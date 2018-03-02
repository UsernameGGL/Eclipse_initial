package com.neusoft.deptmanage.form;

import java.sql.Date;
import java.util.List;

import com.neusoft.deptmanage.domain.Dept;
import com.neusoft.employeemanage.domain.Employee;

import devoid.frame.web.BaseForm;

public class DeptForm extends BaseForm {
	
	private Dept dept = new Dept();
	
	private List<Dept> deptList;
	
	private List<Employee> employeeList;
	
	private List<String> codeList;
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}
	
	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
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
		return dept.getId();
	}
	public void setId(int id) {
		dept.setId(id);
	}
	public int getDept_number(){
		return dept.getDept_number();
	}
	
	public void setDept_number(int dept_number){
		dept.setDept_number(dept_number);
	}
	
	public String getDept_name(){
		return dept.getDept_name();
	}
	
    public void setDept_name(String dept_name){
    	dept.setDept_name(dept_name);
    }
    
    public int getDept_type() {
		return dept.getDept_type();
	}
    
    public void setDept_type(int dept_type){
    	 dept.setDept_type(dept_type);
    }
    public String getDept_value() {
		return dept.getDept_value();
	}
	public void setDept_value(String dept_value) {
		dept.setDept_value(dept_value);
	}
    public String getDept_tel() {
		return dept.getDept_tel();
	}

	public void setDept_tel(String dept_tel) {
		dept.setDept_tel(dept_tel);
	}

	public String getDept_fax() {
		return dept.getDept_fax();
	}

	public void setDept_fax(String dept_fax) {
		dept.setDept_fax(dept_fax);
	}

	public int getDept_super() {
		return dept.getDept_super();
	}

	public void setDept_super(int dept_super) {
		dept.setDept_super(dept_super);
	}
	public String getDept_superName() {
		return dept.getDept_superName();
	}
	public void setDept_superName(String dept_superName) {
		dept.setDept_superName(dept_superName);
	}

	public String getDept_desc() {
		return dept.getDept_desc();
	}

	public void setDept_desc(String dept_desc) {
		dept.setDept_desc(dept_desc);
	}

	public String getDept_setDate() {
		Date date = dept.getDept_setDate();		
		if(date==null){		
			return null;
		}else{
			return date.toString();
		}		
	}
	
	public void setDept_setDate(String dept_setDate) {
		Date date = null;
		if(dept_setDate!=null&&!"".equals(dept_setDate)){
			 date = Date.valueOf(dept_setDate);
		}
		System.out.println("dept_setDate="+dept_setDate);
		
		dept.setDept_setDate(date);
	}

}
