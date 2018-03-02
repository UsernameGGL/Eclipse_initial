package com.upc.service;

import com.upc.model.User;

public class CheckUserImpl implements CheckUser {

	private CheckUserStrategy strategy;

	public CheckUserStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(CheckUserStrategy strategy) {
		this.strategy = strategy;
	}

	public boolean check(User user) {
		// TODO Auto-generated method stub
		return getStrategy() .check(user);
	}

}
