package com.service.impl;

import com.entity.User;
import com.service.CheckUserStrategy;

public class CheckUserByName implements CheckUserStrategy {

	public boolean check(User user) {
		// TODO Auto-generated method stub
		
		if(user==null)
			return false;
		if(!user.getName().startsWith("upc"))
			return false;
		if(user.getName().length()<6)
			return false;
		if(user.getName().length()>10)
			return false;
		
		return true;
	}

}
