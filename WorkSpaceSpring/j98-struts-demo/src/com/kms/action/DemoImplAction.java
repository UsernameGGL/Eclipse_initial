package com.kms.action;

import com.opensymphony.xwork2.Action;
/**
 * 规范了action类结果，要求每一个excute方法的返回值必须是action接口规定的常量之一;
 * @author 12515
 *
 */
public class DemoImplAction implements Action {

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
