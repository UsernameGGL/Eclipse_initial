package com.po;

import java.io.Serializable;

/** 用于封装Dept部门信息，对外提供函数接口用于数据交�?
 * private int did，部门编�?
 * private String dnm，部门名�?
 * private int dnum，部门员工�?�数
 * @author 刘嘉�?
 */
public class Dept implements Serializable{
	private int did;			//部门编号
	private String dnm;			//部门名称
	private int dnum;			//部门正式员工总数
	//private static final long serialVersionUID = 1724422162143383138L;
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDnm() {
		return dnm;
	}
	public void setDnm(String dnm) {
		this.dnm = dnm;
	}
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
}
