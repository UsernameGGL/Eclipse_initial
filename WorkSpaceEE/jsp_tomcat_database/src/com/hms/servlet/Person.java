package com.hms.servlet;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7603643247395062309L;
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String pnm;
	private String pwd;
	private Date bdate;
	private int rid;
	private int mgid;
	private String icon;
	public Person(String pnm2, String pwd2, String bdate2, String rid2, String mgid2, String icon2) {
		pnm=pnm2;
		pwd=pwd2;
		try {
			bdate = FORMAT.parse(bdate2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rid = Integer.parseInt(rid2);
		mgid = Integer.parseInt(mgid2);
		icon = icon2;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Person(){
		
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
	public static SimpleDateFormat getFormat() {
		return FORMAT;
	}
	
}
