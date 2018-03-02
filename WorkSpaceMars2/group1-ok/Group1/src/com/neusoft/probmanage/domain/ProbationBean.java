package com.neusoft.probmanage.domain;

import java.io.Serializable;
import java.sql.Date;

/**试用期实体类
 * 
 * 
 *
 */
public class ProbationBean implements Serializable{
	
	//员工虚拟编号
	private int id;
	//试用期状态
	private int prob_status;
	//试用期开始时间
	private Date prob_start;
	//试用期结束时间
	private Date  prob_end;
	//试用期评语
	private String prob_reviews;
	//考核结果
	private int prob_results;
	//处理日期
	private Date prob_date;
	//延期到时间
	private Date extend_date;
	//备注
	private String prob_notes;
	//员工现在是否入职
	private int prob_yn;
	//岗位编号
   
	
	private String prob_jobId;
	//岗位名称
	private String prob_jobName;
	//部门名称
	private String prob_branchName;
	//员工姓名
	private String prob_name;
	//部门编号
	private String prob_branchId;
	//员工编号
	private int em_number;
		
	public int getEm_number() {
		return em_number;
	}
	public void setEm_number(int em_number) {
		this.em_number = em_number;
	}
	public int getProb_status() {
		return prob_status;
	}
	public void setProb_status(int Prob_status) {
		this.prob_status = Prob_status;
	}
	public Date getProb_start() {
		return prob_start;
	}
	public void setProb_start(Date Prob_start) {
		this.prob_start = Prob_start;
	}
	public Date  getProb_end() {
		return prob_end;
	}
	public void setProb_end(Date Prob_end) {
		this.prob_end = Prob_end;
	}
	public String getProb_reviews() {
		return prob_reviews;
	}
	public void setProb_reviews(String Prob_reviews) {
		this.prob_reviews = Prob_reviews;
	}
	public int getProb_results() {
		return prob_results;
	}
	public void setProb_results(int Prob_results) {
		this.prob_results = Prob_results;
	}
	public Date getProb_date() {
		return prob_date;
	}
	public void setProb_date(Date Prob_date) {
		this.prob_date = Prob_date;
	}
	public String getProb_notes() {
		return prob_notes;
	}
	public void setProb_notes(String Prob_notes) {
		this.prob_notes = Prob_notes;
	}
	public int getProb_yn() {
		return prob_yn;
	}
	public void setProb_yn(int Prob_yn) {
		this.prob_yn = Prob_yn;
	}
	public String getProb_jobId() {
		return prob_jobId;
	}
	public void setProb_jobId(String prob_jobId) {
		this.prob_jobId = prob_jobId;
	}
	public String getProb_jobName() {
		return prob_jobName;
	}
	public void setProb_jobName(String prob_jobName) {
		this.prob_jobName = prob_jobName;
	}
	public String getProb_branchName() {
		return prob_branchName;
	}
	public void setProb_branchName(String prob_branchName) {
		this.prob_branchName = prob_branchName;
	}
	public String getProb_name() {
		return prob_name;
	}
	public void setProb_name(String prob_name) {
		this.prob_name = prob_name;
	}
	public String getProb_branchId() {
		return prob_branchId;
	}
	public void setProb_branchId(String prob_branchId) {
		this.prob_branchId = prob_branchId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getExtend_date() {
		return extend_date;
	}
	public void setExtend_date(Date extend_date) {
		this.extend_date = extend_date;
	}
	

	
	
	

	
}
