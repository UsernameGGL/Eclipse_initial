package com.kms6.action;

import com.kms6.pojo.Role;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RoleFormAction extends ActionSupport implements ModelDriven<Role>{
	private int rid;
	private String rnm;
	private Role role = new Role();//必须立即实例化
	//如果没有实例化，则pojo类只能收到最后一个form表单的值
	@Override
	public String execute() throws Exception {
		System.out.println(rid);
		System.out.println(rnm);
		System.out.println(role.getRid());
		System.out.println(role.getRnm());
		return super.execute();
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRnm() {
		return rnm;
	}
	public void setRnm(String rnm) {
		this.rnm = rnm;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public Role getModel() {
		if(this.role==null){
			this.role=new Role();
		}
		return this.role;
	}
}
