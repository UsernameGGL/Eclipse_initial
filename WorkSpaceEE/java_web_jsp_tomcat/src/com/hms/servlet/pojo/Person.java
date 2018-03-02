package com.hms.servlet.pojo;

import java.io.Serializable;

/**
 * 
 * JavaBean 标准
 * 1、父类是Objiect
 * 2、具有默认无参的构造函数
 * 3、所有的属性都是私有的
 * 4、所有的属性都有提供get/set方法，且方法名满足固定格式
 * 		如：aaa  --  getAaaa, 和setAaa; aaaBbb  --  getAaaBbb/setAaaBbb
 * 5、所有属性的名字的首字符必须是小写的
 * 6、不建议再提供其他方法
 * 7、特例：private boolean male; setMale()/isMale()（boolean类型是特殊的）
 * 8、建议实现Serializable接口
 * @author 12515
 *
 */

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pid;

	public Person(String pid2, String pnm, String pwd, String bdate, String rid, String mgid, String icon) {
		// TODO Auto-generated constructor stub
		if(pid2!=null&&pid2.length()>0){
			this.pid=Integer.parseInt(pid2);
		}
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}


	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
}


