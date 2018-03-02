package com.service.impl;

import com.entity.User;
import com.service.CheckUserStrategy;

public class CheckUserByPwd implements CheckUserStrategy {

	public boolean check(User user) {
		// TODO Auto-generated method stub
		
		if(user==null)
			return false;
		
		if(!user.getPwd().startsWith("2017"))
			return false;
		
		if(user.getPwd().length()<8||user.getPwd().length()>20)
			return false;
		
		return true;
	}

}
