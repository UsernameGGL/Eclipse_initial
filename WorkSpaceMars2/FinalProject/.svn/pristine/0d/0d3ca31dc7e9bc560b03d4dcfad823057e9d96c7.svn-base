package com.kms.action;

import java.util.List;

import com.kms.dao.JobInfoDao;
import com.kms.dao.WorkerDao;
import com.kms.po.JobInfo;
import com.kms.po.LoginRole;
import com.kms.po.WorkInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**登录校验action
 * public String login(LoginRole loginRole) 
 * @author 刘嘉赓
 *
 */
public class LoginAction extends ActionSupport implements ModelDriven<LoginRole> {
	private static final String rootAccount = "root";
	private static final String rootPassword = "root";
	
	LoginRole loginRole = new LoginRole();
	private WorkInfo worker=new WorkInfo();
	private WorkerDao wDao=new WorkerDao();
	
	/**登录信息校验函数
	 * 如果是管理员则返回："root" ；
	 * 如果是普通用户则返回："normal" ；
	 * 否则返回："error" ；
	 * @param loginRole
	 * @return
	 */
	public String login(){
		if (loginRole.getAccountNumber().equals(rootAccount)&&loginRole.getPassword().equals(rootPassword)){
			return "root";
		}else {
			List<JobInfo> list = new JobInfoDao().listJobInfo();
			for (int i=0;i<list.size();i++){
				JobInfo jobInfo = list.get(i);
				if (jobInfo.getJid().equals(loginRole.getAccountNumber())&&jobInfo.getJid().equals(loginRole.getPassword())){
					worker=wDao.find(loginRole.getAccountNumber());
					return "normal";
				}
			}
			return "error";
		}
	}

	@Override
	public LoginRole getModel() {
		if (this.loginRole==null){
			this.loginRole = new LoginRole();
		}
		return this.loginRole;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(loginRole.getAccountNumber());
		System.out.println(loginRole.getPassword());
		return SUCCESS;
	}

	public LoginRole getLoginRole() {
		return loginRole;
	}

	public void setLoginRole(LoginRole loginRole) {
		this.loginRole = loginRole;
	}

	public static String getRootaccount() {
		return rootAccount;
	}

	public static String getRootpassword() {
		return rootPassword;
	}

	public WorkInfo getWorker() {
		return worker;
	}

	public void setWorker(WorkInfo worker) {
		this.worker = worker;
	}
}
