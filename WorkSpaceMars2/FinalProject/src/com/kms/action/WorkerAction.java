package com.kms.action;

import java.util.List;
import com.kms.dao.WorkerDao;
import com.kms.po.WorkInfo;
import com.kms.po.WorkerSalary;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 封装对在职职员表workerinfo操作
 * @author 张金海
 *
 */
public class WorkerAction extends ActionSupport implements ModelDriven<WorkInfo>{
	private WorkInfo worker=new WorkInfo();
	private WorkerDao wDao=new WorkerDao();
	private List<WorkInfo> lrs;
	private List<WorkerSalary> salList;
	private String jposi;
	private String jdept;
	private String jsal;
	private String key;
	
	
	/**
	 * 获取职员信息列表，跳转到职员信息页面
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		lrs=wDao.showAllWorker();
		return "list";
	}
	
	public String selectWorker() throws Exception {
		lrs=wDao.selectWorkInfoByKey("%"+getKey()+"%");
		return "list";
	}
	
	public String selectWorkSalary() throws Exception {
		salList=wDao.selectSalByKey("%"+getKey()+"%");
		return "salList";
	}
	/**
	 * 获取职员薪金列表，跳转到列表页面
	 * @return
	 * @throws Exception
	 */
	public String salList() throws Exception {
		setSalList(wDao.showSalary());
		return "salList";
	}
	public String updateSDP() throws Exception {
		wDao.updateSDP(worker.getWid(), Integer.parseInt(jsal), Integer.parseInt(jdept), Integer.parseInt(jposi));
		return salList();
	}
	
	
	
	
	public String getJdept() {
		return jdept;
	}


	public void setJdept(String jdept) {
		this.jdept = jdept;
	}


	public String getJsal() {
		return jsal;
	}


	public void setJsal(String jsal) {
		this.jsal = jsal;
	}


	/**
	 * 从数据库中找到wid为worker.getRid的一条数据
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		worker=wDao.find(worker.getWid());
		return "edit";
	}
	
	/**
	 * 
	 * 跳转添加页面
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {	
		return "add";
	}
	
	/**
	 * 向workerinfo表中添加一条记录，返回职员信息列表页面
	 * @return
	 * @throws Exception
	 */
	public String addRet() throws Exception {
		int i=wDao.add(worker);
		if(i==-1)
			return "error";
		else
			return list();
	}
	
	
	/**
	 * 删除职员编号wid为worker.getWid()在workerinfo表和jobinfo表中的的相关信息
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		int i=wDao.del(worker.getWid());
		wDao.delSalary(worker.getWid());
		if(i==-1)
			return "error";
		else
			return salList();
	}
	
	
	/**
	 * 保存修改的新的职员信息，返回职员信息列表
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		System.out.println("----------"+worker.getWid()+"-------");
		int i=wDao.edit(worker);
		if(i==1)
			return list();	
		else
			return "error";
	}
	
	@Override
	public WorkInfo getModel() {
		if(this.getWorker()==null)
			this.setWorker(new WorkInfo());
		return getWorker();
	}

	public WorkInfo getWorker() {
		return worker;
	}

	public void setWorker(WorkInfo worker) {
		this.worker = worker;
	}

	public WorkerDao getrDao() {
		return wDao;
	}

	public void setrDao(WorkerDao rDao) {
		this.wDao = rDao;
	}

	public List<WorkInfo> getLrs() {
		return lrs;
	}

	public void setLrs(List<WorkInfo> lrs) {
		this.lrs = lrs;
	}

	public List<WorkerSalary> getSalList() {
		return salList;
	}

	public void setSalList(List<WorkerSalary> salList) {
		this.salList = salList;
	}


	public String getJposi() {
		return jposi;
	}


	public void setJposi(String jposi) {
		this.jposi = jposi;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
