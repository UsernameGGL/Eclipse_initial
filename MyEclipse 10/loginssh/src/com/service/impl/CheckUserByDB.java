package com.service.impl;

import com.entity.User;
import com.entity.UserDAO;
import com.service.CheckUser;

public class CheckUserByDB implements CheckUser {

	private UserDAO userDao;
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean checkUser(User user) {
		// TODO Auto-generated method stub	
		if(userDao.findByExample(user).size()>0)
			return true;	
		return false;
	}
}
