package com.kms6.action;

import com.opensymphony.xwork2.ActionSupport;

public class DemoExtAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		LOG.debug("------ActionSupport.LOG.debug------");
		
		return SUCCESS;
	}
	
}
