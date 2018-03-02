package com.service.impl;

import com.entity.User;
import com.service.CheckUserStrategy;

public class CheckUserByNameNg implements CheckUserStrategy {

	private String startStr;
	private int min;
	private int max;
	
	public String getStartStr() {
		return startStr;
	}

	public void setStartStr(String startStr) {
		this.startStr = startStr;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public boolean check(User user) {
		// TODO Auto-generated method stub
		
		if(user==null)
			return false;
		if(!user.getName().startsWith(startStr))
			return false;
		if(user.getName().length()<min)
			return false;
		if(user.getName().length()>max)
			return false;
		
		return true;
	}

}
