package com.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CheckUser;

@SuppressWarnings("serial")
@Scope("prototype")
public class LoginAction extends ActionSupport {
	
	private String name;
	private String pwd;
	private CheckUser checkUser;

	public CheckUser getCheckUser() {
		return checkUser;
	}

	public void setCheckUser(CheckUser checkUser) {
		this.checkUser = checkUser;
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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
				
		User user= new User();
		user.setName(name);
		user.setPwd(pwd);
		
		ServletActionContext.getRequest().
		setAttribute("name", name);
		
		if(checkUser.checkUser(user))
		{
			return "success";
		}else{
			return "failure";
		}
	}
}
