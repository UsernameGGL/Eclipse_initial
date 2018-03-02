package com.kms.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**按关键字或日期进行查询所需的信息：
 * private String keyWord：查询的关键字；
 * private Date former：日期范围下限；
 * private Date latter：日期范围上限；
 * 
 * @author 刘嘉赓
 *
 */
public class KeyWord {
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private String keyWord = "";
	private Date former = new Date(0);
	private Date latter = new Date();
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Date getFormer() {
		return former;
	}
	public void setFormer(Date former) {
		this.former = former;
	}
	public void setFormer(String former) {
		try {
			this.former = FORMAT.parse(former);
		} catch (ParseException e) {
			this.former = new Date(0);
			System.out.println("初始化former失败！");
		}
	}
	public Date getLatter() {
		return latter;
	}
	public void setLatter(Date latter) {
		this.latter = latter;
	}
	public void setLatter(String latter) {
		try {
			this.latter = FORMAT.parse(latter);
		} catch (ParseException e) {
			this.latter = new Date();
			System.out.println("初始化latter失败！");
		}
	}
}
