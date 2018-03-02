package com.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CheckUser;

public class LoginAction extends ActionSupport {
	
	private String name;
	private String pwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("15:"+name);
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
		
		ClassPathXmlApplicationContext cpxl = 
				new ClassPathXmlApplicationContext
				("applicationContext1.xml");
    	CheckUser checkUser = (CheckUser)cpxl.getBean("checkUser");
		
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
