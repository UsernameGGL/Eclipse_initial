package com.neusoft.employeemanage.domain;

import java.io.Serializable;
import java.sql.Date;

public class All implements Serializable{
    //����Ա�����
	private int id;
	//*Ա�����
	private int em_number;
	//*Ա������
	private String em_name;
	//���ű��
	private int dept_number;	
	//��������
	private String dept_name;
	//���ŵ�ת����
	private int dept_chType;
	//���ſ�ʼ����
	private String dept_startDate;
	//���Ž�������
	private String dept_endDate;
	//��λ���
	private int job_number;	
    //*��λ����
	private String job_name;
	//*��λ��ת����
	private String job_chType;
	//*��λ��ʼ����
	private Date job_startDate;
	//*��λ��������
	private Date job_endDate;
	//��־
    private int situation;	
	
	//*ת����ѯ��ʼ����
	private String prob_startDate;
	//*ת��������������
	private String prob_endDate;
	
	//*���ô�������
	private Date prob_Date;
	

	//�����ڿ�ʼʱ��
	private Date prob_start;
	//�����ڽ���ʱ��
	private Date prob_end;
	
	
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

	//�ù���ʽ
	private int em_format;
	
	//��ְ��ʼ����
	private String begin_date;
	//��ְ��������
	 private String end_date;
	 
	 //��ְ����
     private int lz_type;
	
	public int getLz_type() {
		return lz_type;
	}
	public void setLz_type(int lz_type) {
		this.lz_type = lz_type;
	}
	
	public String getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getEm_format() {
		return em_format;
	}
	public void setEm_format(int em_format) {
		this.em_format = em_format;
	}

	public String getEm_name() {
		return em_name;
	}
	public void setEm_name(String em_name) {
		this.em_name = em_name;
	}
	
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public int getDept_chType() {
		return dept_chType;
	}
	public void setDept_chType(int dept_chType) {
		this.dept_chType = dept_chType;
	}
	public String getDept_startDate() {
		return dept_startDate;
	}
	public void setDept_startDate(String dept_startDate) {
		this.dept_startDate = dept_startDate;
	}
	public String getDept_endDate() {
		return dept_endDate;
	}
	public void setDept_endDate(String dept_endDate) {
		this.dept_endDate = dept_endDate;
	}
	public String getJob_chType() {
		return job_chType;
	}
	public void setJob_chType(String job_chType) {
		this.job_chType = job_chType;
	}
	public Date getJob_startDate() {
		return job_startDate;
	}
	public void setJob_startDate(Date job_startDate) {
		this.job_startDate = job_startDate;
	}
	public Date getJob_endDate() {
		return job_endDate;
	}
	public void setJob_endDate(Date job_endDate) {
		this.job_endDate = job_endDate;
	}
	public String getProb_startDate() {
		return prob_startDate;
	}
	public void setProb_startDate(String prob_startDate) {
		this.prob_startDate = prob_startDate;
	}
	
	public String getProb_endDate() {
		return prob_endDate;
	}
	public void setProb_endDate(String prob_endDate) {
		this.prob_endDate = prob_endDate;
	}
	public int getEm_number() {
		return em_number;
	}
	public void setEm_number(int em_number) {
		this.em_number = em_number;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getProb_Date() {
		return prob_Date;
	}
	public void setProb_Date(Date prob_Date) {
		this.prob_Date = prob_Date;
	}

	public int getSituation() {
		return situation;
	}
	public void setSituation(int situation) {
		this.situation = situation;
	}
	
	
	
}
