package com.kms.action;

import java.util.ArrayList;
import java.util.List;

import com.kms.dao.PersonDao;
import com.kms.dao.RoleDao_test;
import com.kms.pojo.Person;
import com.kms.pojo.Role;
import com.opensymphony.xwork2.ModelDriven;

public class PersonAction extends MyAction {
	private List<Person> ls;
	private List<Role> ls_2;
	public String list2(){
		RoleDao_test rd=new RoleDao_test();
		ls_2=rd.lrs();
		for(Person i : ls){
			System.out.println(i.getIcon());
		}
		return LIST;
	}
	public String list(){
		PersonDao pd=new PersonDao();
		ls=pd.lrs();
		for(Person i : ls){
			System.out.println(i.getIcon());
		}
		return LIST;
	}
	public List<Person> getLs() {
		return ls;
	}
	public void setLs(List<Person> ls) {
		this.ls = ls;
	}

	
}
