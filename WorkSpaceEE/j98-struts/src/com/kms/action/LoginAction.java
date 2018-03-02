package com.kms.action;

public class LoginAction {
	/**
	 * action的属性名和form表单元素的名称name属性值必须完全相同
	 * 必须为私有的属性提供公共的ger/set方法
	 */
	private String pnm;
	private String pwd;
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
	public String login() {
		System.out.println(pnm);
		System.out.println(pwd);
		return "success";
	}
}
