package com.kms6.action;

import com.opensymphony.xwork2.ActionSupport;

public class RoleDmiAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		System.out.println("excute");
		return SUCCESS;
	}
	public String del(){
		System.out.println("del");
		return SUCCESS;
	}
	public String list(){
		System.out.println("list");
		return SUCCESS;
	}
	public String add(){
		System.out.println("add");
		return SUCCESS;
	}
	public String update(){
		System.out.println("update");
		return SUCCESS;
	}
}
