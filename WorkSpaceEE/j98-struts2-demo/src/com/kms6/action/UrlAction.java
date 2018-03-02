package com.kms6.action;

import com.opensymphony.xwork2.ActionSupport;

public class UrlAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		LOG.debug("URL action");
		return SUCCESS;
	}
}
