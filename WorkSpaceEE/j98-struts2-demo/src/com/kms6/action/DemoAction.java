package com.kms6.action;

public class DemoAction {
	public String execute(){
		System.out.println(msg);
		return "success";
	}
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
