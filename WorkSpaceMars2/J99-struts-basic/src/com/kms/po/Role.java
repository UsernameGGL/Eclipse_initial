package com.kms.po;
/**
 * 持久化对象类
 * 类名和表名一致，属性名和列名一致
 * 在给表和列命名的过程中，必须考虑Java和sql的关键字冲突问题
 * @author 12515
 *
 */
public class Role {
	private int roleid;
	private String nm;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
}
