package com.kms.po;

import java.io.Serializable;


/**
 * 用于封装员工信息表(workerinfo)中的信息，
 * 对外提供接口函数供数据交换
 * @author 张金海
 *
 */
public class WorkInfo implements Serializable{
	private static final long serialVersionUID = -5516323463684893414L;
	private String wid;
	private String wnm;
	private String wsex;
	private String wna;
	private String wiid;
	private String wtel;
	private String wedu;
	private String wloc;
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getWnm() {
		return wnm;
	}
	public void setWnm(String wnm) {
		this.wnm = wnm;
	}
	public String getWsex() {
		return wsex;
	}
	public void setWsex(String wsex) {
		this.wsex = wsex;
	}
	public String getWna() {
		return wna;
	}
	public void setWna(String wna) {
		this.wna = wna;
	}
	public String getWiid() {
		return wiid;
	}
	public void setWiid(String wiid) {
		this.wiid = wiid;
	}
	public String getWtel() {
		return wtel;
	}
	public void setWtel(String wtel) {
		this.wtel = wtel;
	}
	public String getWedu() {
		return wedu;
	}
	public void setWedu(String wedu) {
		this.wedu = wedu;
	}
	public String getWloc() {
		return wloc;
	}
	public void setWloc(String wloc) {
		this.wloc = wloc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
