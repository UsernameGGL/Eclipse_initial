package com.kms.po;


/**
 * 用于封装申请表(apply)中的信息，
 * 对外提供接口函数供数据交换
 * @author 张金海
 *
 */
public class Apply {
	private int rid;
	private String anm;
	private String aedu;
	private String apos;
	private String asex;
	private int aage;
	private String ana;
	private String aid;
	private String atel;
	private String aloc;
	private int adel;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getAnm() {
		return anm;
	}
	public void setAnm(String anm) {
		this.anm = anm;
	}
	public String getAedu() {
		return aedu;
	}
	public void setAedu(String aedu) {
		this.aedu = aedu;
	}
	public String getApos() {
		return apos;
	}
	public void setApos(String apos) {
		this.apos = apos;
	}
	public String getAsex() {
		return asex;
	}
	public void setAsex(String asex) {
		this.asex = asex;
	}
	public int getAage() {
		return aage;
	}
	public void setAage(int aage) {
		this.aage = aage;
	}
	public String getAna() {
		return ana;
	}
	public void setAna(String ana) {
		this.ana = ana;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAtel() {
		return atel;
	}
	public void setAtel(String atel) {
		this.atel = atel;
	}
	public String getAloc() {
		return aloc;
	}
	public void setAloc(String aloc) {
		this.aloc = aloc;
	}
	public int getAdel() {
		return adel;
	}
	public void setAdel(int adel) {
		this.adel = adel;
	}
}
