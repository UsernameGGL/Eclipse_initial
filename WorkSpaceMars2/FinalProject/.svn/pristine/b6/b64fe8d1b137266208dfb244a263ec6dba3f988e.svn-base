package com.kms.action;

import java.util.List;

import com.kms.dao.ChangeDao;
import com.kms.po.Change;
import com.kms.po.KeyWord;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**管理变更记录的action，
 * 可以查询所有的变更记录，
 * 也可以按照关键字（姓名或变更操作类型）及日期查询。
 * 
 * public String listChange() 查询所有的变更记录
 * public String listChangeByKeyWord() 按关键字及日期范围查询变更记录
 * 
 * @author 刘嘉赓
 *
 */
public class ChangeListAction extends ActionSupport implements ModelDriven<Change> {
	private KeyWord keyW = new KeyWord();
	private Change change = new Change();
	private static ChangeDao changeDao = new ChangeDao();
	private List<Change> list = null;
	
	/**查询所有的变更记录
	 * @return
	 */
	public String listChange(){
		list = changeDao.listChange();
		if (this.list==null){
			return "error";
		}else {
			return "listChange";
		}
	}
	
	/**按关键字（姓名或操作）及日期进行查询
	 * @return
	 */
	public String listChangeByKeyWord(){
		list = changeDao.listChangeByKW(keyW);
		if (this.list==null){
			return "error";
		}else {
			return "listChangeByKeyWord";
		}
	}

	@Override
	public Change getModel() {
		if (this.change==null){
			this.change = new Change();
		}
		return this.change;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
//	用于ModelDriven方法获取实例化的change的值	
	public Change getChange() {
		return change;
	}
//	用于ModelDriven方法设置实例化的change的值
	public void setChange(Change change) {
		this.change = change;
	}
//	用于ModelDriven方法获取实例化的list的值
	public List<Change> getList() {
		return this.list;
	}
//	用于ModelDriven方法获取实例化的keyW的值
	public KeyWord getKeyW() {
		return keyW;
	}
//	用于ModelDriven方法设置实例化的keyW的值
	public void setKeyW(KeyWord keyW) {
		this.keyW = keyW;
	}
}
