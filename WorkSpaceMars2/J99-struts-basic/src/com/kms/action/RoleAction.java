package com.kms.action;

import java.util.List;

import com.kms.dao.RoleDao;
import com.kms.po.Role;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RoleAction extends ActionSupport implements ModelDriven {
	private Role role=new Role();//必须实例化
	public String findone() throws Exception {
		RoleDao rd = new RoleDao();
		role = rd.findone(role.getRoleid());
		return "edit";
	}

	
	public String edit() throws Exception {
		RoleDao rd = new RoleDao();
		int i = rd.edit(role);
		if (i == 0) {
			return ERROR;
		} else {
			return this.list();
		}
	}

	
	public String add() throws Exception {
		RoleDao rd = new RoleDao();
		int i = rd.add(this.role);
		if (i == 0) {
			return ERROR;
		} else {
			return this.list();
		}
	}
	
	public String list() throws Exception {
		RoleDao rd=new RoleDao();
		lrs=rd.lrs();
		return "list";
	}
	
	//向页面传值
	private List<Role> lrs;
	
	
	public List<Role> getLrs() {
		return lrs;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public Object getModel() {
		if (this.role==null) {
			this.role=new Role();
		}
		return role;
	}
}
