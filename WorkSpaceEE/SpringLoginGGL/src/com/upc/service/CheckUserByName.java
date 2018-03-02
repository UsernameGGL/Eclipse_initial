package com.upc.service;

import com.upc.model.User;

public class CheckUserByName implements CheckUserStrategy {
	
	private int minLength;
	private int maxLength;
	private String namePrefix;
	
	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	
	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public String getNamePrefix() {
		return namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public boolean check(User user) {
		// TODO Auto-generated method stub
		String name = user.getName();
		
		if(name!=null
				&&name.length()>=getMinLength() 
				&&name.length()<=getMaxLength()
				&&name.startsWith(getNamePrefix()))
			return true;
		
		return false;
	}

}
