package com.kms.po;

import java.io.Serializable;
/**
 * 封装在职信息表的属性
 * jid员工编号
 * jnm员工姓名
 * jage年龄
 * jpid岗位编号
 * jdid部门编号
 * jsal薪金
 * @author 高国亮
 *
 */
public class JobInfo implements Serializable {
	/**
	 * 自然生成的序列化ID
	 */
	private static final long serialVersionUID = -6244501064514716627L;
	private String jid;//员工编号
	private String jnm;//员工姓名
	private int jage;//年龄
	private int jpid;//岗位编号
	private int jdid;//部门编号
	private int jsal;//薪金
	
	private String dnm;			//部门名称
	private String pnm;			//岗位名称
	
	public String getPnm() {
		return pnm;
	}
	public void setPnm(String pnm) {
		this.pnm = pnm;
	}
	public String getDnm() {
		return dnm;
	}
	public void setDnm(String dnm) {
		this.dnm = dnm;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	public String getJnm() {
		return jnm;
	}
	public void setJnm(String jnm) {
		this.jnm = jnm;
	}
	public int getJage() {
		return jage;
	}
	public void setJage(int jage) {
		this.jage = jage;
	}
	public int getJpid() {
		return jpid;
	}
	public void setJpid(int jpid) {
		this.jpid = jpid;
	}
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}
	public int getJsal() {
		return jsal;
	}
	public void setJsal(int jsal) {
		this.jsal = jsal;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
