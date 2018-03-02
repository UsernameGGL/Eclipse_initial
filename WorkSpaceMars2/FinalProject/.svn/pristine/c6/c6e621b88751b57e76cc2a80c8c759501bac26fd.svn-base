package com.kms.action;

import java.util.List;

import com.kms.dao.PositionDao;
import com.kms.po.JobInfo;
import com.kms.po.Position;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**用于封装对岗位管理模块的操作，响应相应的Action；
 * 
 * public String add() 添加新的岗位信息；
 * public String delete() 删除指定的岗位信息；
 * public String update() 修改岗位名称；
 * public String listposition() 列举所有的岗位信息；
 * 
 * @author 刘嘉赓
 */
public class PositionFormAction extends ActionSupport implements ModelDriven<Position> {
	private static final String LISTPOSITION = "listposition";
	private static final String LISTPERSON = "listperson";
	private static final String ERROR = "error";
	
	private Position position = new Position();
	private PositionDao positionDao = new PositionDao();
	private List<Position> listPosition;
	private List<JobInfo> listPerson;
	
	@Override
	public Position getModel() {
		if (this.position == null){
			this.position = new Position();
		}
		return position;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(position.getPid());
		System.out.println(position.getPnm());
		System.out.println(position.getPnum());
		return SUCCESS;
	}
	
	/**添加新的岗位信息，
	 * 需要从jsp页面获取新的岗位名称
	 * @return String add
	 */
	public String add() {
		if (positionDao.addPosition(position) == 0){
			return ERROR;
		}else {
			System.out.println("--addposition---------------------------------");
			return this.listposition();
		}
	}

	/**删除指定的岗位信息，
	 * 需要从jsp页面获取岗位编号
	 * @return String delete
	 */
	public String delete() {
		if (positionDao.deletePosition(position) == 0){
			return ERROR;
		}else {
			System.out.println("--deleteposition---------------------------------");
			return this.listposition();
		}
	}

	/**修改岗位名称，
	 * 需要从jsp页面获取部门编号以及新的岗位名称
	 * @return String update
	 */
	public String update() {
		if (positionDao.updatePosition(position) == 0){
			return ERROR;
		}else {
			System.out.println("--updateposition---------------------------------");
			return this.listposition();
		}
	}
	
	/**列举所有的岗位信息，
	 * 将从数据库查询到的结果返回到listPosition中
	 * @return String listposition
	 */
	public String listposition() {
		System.out.println("--listposition--------------------------------");
		listPosition = positionDao.listPosition();
		return LISTPOSITION;
	}
	
	/**列举岗位所属所有员工的员工编号，姓名，年龄，部门，薪金
	 * 将从数据库查询到的结果返回到listPerson中
	 * @return String listperson
	 */
	public String listperson() {
		System.out.println("--listperson--------------------------------");
		listPerson = positionDao.listPerson(position);
		return LISTPERSON;
	}
	
//	用于ModelDriven方法获取实例化的listPosition的值
	public List<Position> getListPosition() {
		return listPosition;
	}
//	用于ModelDriven方法获取实例化的listPerson的值
	public List<JobInfo> getListPerson() {
		return listPerson;
	}
//	用于ModelDriven方法获取实例化的position的值
	public Position getPosition() {
		return position;
	}
//	用于ModelDriven方法向实例化的position传值
	public void setPosition(Position position) {
		this.position = position;
	}
}
