package com.neusoft.jobmanage.domain;

import java.io.Serializable;

/**
 * ��λʵ����
 * @author ttc
 *
 */
//Serializable,����java�ṩ��ͨ�����ݱ���Ͷ�ȡ�Ľӿڡ����ڴ�ʲô�ط��������ͱ��浽����ȥ���������ں��������ı�����
public class Job implements Serializable{
//	*��λ���
	private int job_number;
//	*��λ����
	private String job_name;
//	*��λ����
	private String job_type;
//	*��λ����
	private String job_max;
//	*�ڸ�����
	private int job_man;
//	*��λ״̬
	private int job_situation;
	
	public int getJob_number() {
		return job_number;
	}
	public void setJob_number(int job_number) {
		this.job_number = job_number;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_type() {
		return job_type;
	}
	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	
	public String getJob_max() {
		return job_max;
	}
	public void setJob_max(String job_max) {
		this.job_max = job_max;
	}
	public int getJob_man() {
		return job_man;
	}
	public void setJob_man(int job_man) {
		this.job_man = job_man;
	}
	public int getJob_situation() {
		return job_situation;
	}
	public void setJob_situation(int job_situation) {
		this.job_situation = job_situation;
	}	
	
}
