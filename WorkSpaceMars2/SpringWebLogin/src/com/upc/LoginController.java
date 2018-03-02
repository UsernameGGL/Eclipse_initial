package com.upc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.upc.bean.LoginBean;
import com.upc.model.User;
import com.upc.service.CheckUser;
@SuppressWarnings("deprecation")

public class LoginController extends SimpleFormController {
	
	private String sussPage;
	private String failurePage;
	
	public ModelAndView onSubmit(Object command) throws Exception {
    	//强制转换成HelloWorld
    	//HelloWorld helloWorld = (HelloWorld)command;
		
		LoginBean lb = (LoginBean)command;
		
		ApplicationContext  context = new FileSystemXmlApplicationContext("applicationContext.xml");
		CheckUser cu = (CheckUser)context.getBean("loginValidate");
		
		boolean flag = cu.check(new User(lb.getName(),lb.getPwd()));
		Map model = new HashMap(); 
		model.put("username", lb.getName()); 
		
        if(flag){
        	return new ModelAndView(getSussPage(), model); 
        }else
        {
        	return new ModelAndView(getFailurePage(), model); 
        }
    } 
	
	public String getSussPage() {
		return sussPage;
	}

	public void setSussPage(String sussPage) {
		this.sussPage = sussPage;
	}

	public String getFailurePage() {
		return failurePage;
	}

	public void setFailurePage(String failurePage) {
		this.failurePage = failurePage;
	}
}
