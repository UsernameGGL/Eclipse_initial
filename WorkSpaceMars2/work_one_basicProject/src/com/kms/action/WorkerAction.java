package com.kms.action;

import java.util.List;

import com.kms.dao.WorkerDao;
import com.kms.pojo.Worker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class WorkerAction extends ActionSupport implements ModelDriven{
	private int number;//受影响的行数
	private Worker worker=new Worker();//接收表单数据
	private List<Worker> lrs;//查询结果集
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		if(worker==null)
			worker=new Worker();
		return worker;
	}
	
	
	//动作函数
	public String list(){
		WorkerDao wd=new WorkerDao();
		lrs=wd.lrs();
		return "list";
	}
	
	public String findOne(){
		WorkerDao wd=new WorkerDao();
		worker = wd.findOne(worker.getWorkerNo());
		return "list";
	}
	
	public String update(){
		WorkerDao wd=new WorkerDao();
		number=wd.update(worker);
		return this.list();
	}
	
	public String delete(){
		WorkerDao wd=new WorkerDao();
		number=wd.delete(worker.getWorkerNo());
		return this.list();
	}
	
	//默认的get/set函数
	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public List<Worker> getLrs() {
		return lrs;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}
	
}
