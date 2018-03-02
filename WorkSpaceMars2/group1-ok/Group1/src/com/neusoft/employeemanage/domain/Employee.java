package com.neusoft.employeemanage.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 员工实体类
 * 
 *
 */
public class Employee implements Serializable{
	
	//*员工编号
	private int em_number;
	//*员工姓名
	private String em_name;
	//出生日期
	private Date em_birth;
	//*性别
	private int sex;
	//*用工形式
	private int em_format;
	//*人员来源
	private int em_source;
	//*政治面貌
	private int em_polity;
	//*民族
	private int em_folk;
	//*身份证号
	private String em_id;
	//*入职日期
	private Date em_indate;
	//*参加工作时间
	private Date em_worktime;
	
	
	//籍贯
	private String em_birthplace;
	//联系电话
	private String em_phone;
	//电子邮件
	private String em_mail;
	//血型
	private int em_blood;
	//婚姻状况
	private int em_wedlock;
	//身高
	private String em_stature;
	//部门编号
	private int dept_number;
	//岗位编号
	private int job_number;
	//用户所在地
	private String em_seat;
	//最高学历
	private int em_learn;
	//最高学位
	private int em_degree;
	//毕业院校
	private String em_graduate;
	//所学专业
	private String em_specialty;
	//毕业日期
	private Date em_gradate;
	//出生地
	private String em_homeplace;
	//试用期状态
	private int situation;
	
	//试用期开始时间
	private Date prob_start;
	//试用期结束时间
	private Date prob_end;
	
	private int id;
	
	private String dept_name;
	
	private String job_name;
	
	
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
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
	public Date getEm_birth() {
		return em_birth;
	}
	public void setEm_birth(Date em_birth) {
		this.em_birth = em_birth;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getEm_format() {
		return em_format;
	}
	public void setEm_format(int em_format) {
		this.em_format = em_format;
	}
	public int getEm_source() {
		return em_source;
	}
	public void setEm_source(int em_source) {
		this.em_source = em_source;
	}
	public int getEm_polity() {
		return em_polity;
	}
	public void setEm_polity(int em_polity) {
		this.em_polity = em_polity;
	}
	public int getEm_folk() {
		return em_folk;
	}
	public void setEm_folk(int em_folk) {
		this.em_folk = em_folk;
	}
	public String getEm_id() {
		return em_id;
	}
	public Date getEm_indate() {
		return em_indate;
	}
	public void setEm_indate(Date em_indate) {
		this.em_indate = em_indate;
	}
	public Date getEm_worktime() {
		return em_worktime;
	}
	public void setEm_worktime(Date em_worktime) {
		this.em_worktime = em_worktime;
	}
	public String getEm_birthplace() {
		return em_birthplace;
	}
	public void setEm_birthplace(String em_birthplace) {
		this.em_birthplace = em_birthplace;
	}
	public String getEm_phone() {
		return em_phone;
	}
	public void setEm_phone(String em_phone) {
		this.em_phone = em_phone;
	}
	public String getEm_mail() {
		return em_mail;
	}
	public void setEm_mail(String em_mail) {
		this.em_mail = em_mail;
	}
	public int getEm_blood() {
		return em_blood;
	}
	public void setEm_blood(int em_blood) {
		this.em_blood = em_blood;
	}
	public int getEm_wedlock() {
		return em_wedlock;
	}
	public void setEm_wedlock(int em_wedlock) {
		this.em_wedlock = em_wedlock;
	}
	public String getEm_stature() {
		return em_stature;
	}
	public void setEm_stature(String em_stature) {
		this.em_stature = em_stature;
	}
	public int getDept_number() {
		return dept_number;
	}
	public void setDept_number(int dept_number) {
		this.dept_number = dept_number;
	}
	public int getJob_number() {
		return job_number;
	}
	public void setJob_number(int job_number) {
		this.job_number = job_number;
	}
	public String getEm_seat() {
		return em_seat;
	}
	public void setEm_seat(String em_seat) {
		this.em_seat = em_seat;
	}
	public int getEm_learn() {
		return em_learn;
	}
	public void setEm_learn(int em_learn) {
		this.em_learn = em_learn;
	}
	public int getEm_degree() {
		return em_degree;
	}
	public void setEm_degree(int em_degree) {
		this.em_degree = em_degree;
	}
	public String getEm_graduate() {
		return em_graduate;
	}
	public void setEm_graduate(String em_graduate) {
		this.em_graduate = em_graduate;
	}
	public String getEm_specialty() {
		return em_specialty;
	}
	public void setEm_specialty(String em_specialty) {
		this.em_specialty = em_specialty;
	}
	public Date getEm_gradate() {
		return em_gradate;
	}
	public void setEm_gradate(Date em_gradate) {
		this.em_gradate = em_gradate;
	}
	public String getEm_homeplace() {
		return em_homeplace;
	}
	public void setEm_homeplace(String em_homeplace) {
		this.em_homeplace = em_homeplace;
	}
	public int getSituation() {
		return situation;
	}
	public void setSituation(int situation) {
		this.situation = situation;
	}
	public Date getProb_start() {
		return prob_start;
	}
	public void setProb_start(Date prob_start) {
		this.prob_start = prob_start;
	}
	public Date getProb_end() {
		return prob_end;
	}
	public void setProb_end(Date prob_end) {
		this.prob_end = prob_end;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public void setEm_id(String em_id) {
		this.em_id = em_id;
	}
	
	
	
	
	
	
	
	

	
}
