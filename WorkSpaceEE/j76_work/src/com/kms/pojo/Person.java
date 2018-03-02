package com.kms.pojo;

import java.util.Date;

public class Person {
	private int pid;
	private String pnm;
	private String pwd;
	private Date bdate;
	private int rid;
	private int mgid;
	private String icon;
	public Person(int pid,String pnm,String pwd,Date bdate,int rid,int mgid,String icon){
		this.pid=pid;
		this.pnm=pnm;
		this.pwd=pwd;
		this.bdate=bdate;
		this.rid=rid;
		this.mgid=mgid;
		this.icon=icon;
	}
	public Person(){}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPnm() {
		return pnm;
	}
	public void setPnm(String pnm) {
		this.pnm = pnm;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getMgid() {
		return mgid;
	}
	public void setMgid(int mgid) {
		this.mgid = mgid;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}
