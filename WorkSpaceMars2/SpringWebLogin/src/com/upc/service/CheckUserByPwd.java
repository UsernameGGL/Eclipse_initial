package com.upc.service;

import com.upc.model.User;

public class CheckUserByPwd implements CheckUserStrategy {

	private int minLength;
	private int maxLength;
	private String pwdPrefix;
	
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
	
	
	public String getPwdPrefix() {
		return pwdPrefix;
	}

	public void setPwdPrefix(String pwdPrefix) {
		this.pwdPrefix = pwdPrefix;
	}

	public boolean check(User user) {
		// TODO Auto-generated method stub
		
		String pwd = user.getPwd();
		
		if(pwd!=null
				&&pwd.length()>=getMinLength() 
				&&pwd.length()<=getMaxLength()
				&&pwd.startsWith(getPwdPrefix()))
			return true;
		
		return false;
	}

}
