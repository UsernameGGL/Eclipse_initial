package com.kms.pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable{
	private static final long serialversionUID = 2160432179991986875L;
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private String name;
	private String pwd;
	private int age;
	private Date date;
	public Person(){
		
	}
	public Person(String name2, String pwd2, String age2, String date2) {
		this.name = name2;
		this.pwd = pwd2;
		this.age = Integer.parseInt(age2);
		try {
			this.date = FORMAT.parse(date2);
		} catch (ParseException e) {
			System.out.println("日期转换失败！"+e.getMessage());
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
