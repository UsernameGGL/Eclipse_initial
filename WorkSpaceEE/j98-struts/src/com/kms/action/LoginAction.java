package com.kms.action;

public class LoginAction {
	/**
	 * action����������form��Ԫ�ص�����name����ֵ������ȫ��ͬ
	 * ����Ϊ˽�е������ṩ������ger/set����
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
