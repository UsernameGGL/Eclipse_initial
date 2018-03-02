package com.service.impl;

import com.entity.User;
import com.service.CheckUser;
import com.service.CheckUserStrategy;

public class CheckUserImpl implements CheckUser {
	
	private CheckUserStrategy  strategy;
	
	public CheckUserStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(CheckUserStrategy strategy) {
		this.strategy = strategy;
	}

	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		return getStrategy().check(user);
	}

}
