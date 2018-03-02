package com.kms.action;

import java.util.List;

import com.kms.dao.JobInfoDao;
import com.kms.po.JobInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 响应对在职信息表操作除法的action
 * public String list()罗列在职信息
 * public String update()修改某员工的在职信息
 * @author 高国亮
 *
 */
public class JobInfoAction extends ActionSupport implements ModelDriven<JobInfo> {

	private JobInfo jobInfo = new JobInfo();
	private static JobInfoDao jobInfoDao = new JobInfoDao();
	private List<JobInfo> salList;
	
	@Override
	public JobInfo getModel() {
		// TODO Auto-generated method stub
		if(jobInfo==null){
			jobInfo=new JobInfo();
		}
		return jobInfo;
	}
	
	public String list(){
		salList = jobInfoDao.listJobInfo();
		if(salList==null){
			return "error";
		}
		for(JobInfo i : salList){
			System.out.println(i.getJid());
		}
		return "list";
	}
	
	public String update(){
		int i=jobInfoDao.updateJobInfo(jobInfo);
		if(i==0){
			return "error";
		}
		return this.list();
	}
	
	public String quit(){
		if (jobInfoDao.quitJobInfo(jobInfo) == 0){
			return "error";
		}else {
			return list();
		}
	}

	public List<JobInfo> getSalList() {
		return salList;
	}

	public void setSalList(List<JobInfo> salList) {
		this.salList = salList;
	}
}
