package com.kms.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kms.dao.ProbationDao;
import com.kms.po.Apply;
import com.kms.po.Probation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 封装apply表的操作
 * @author 张金海
 *
 */
public class ApplyAction extends ActionSupport implements ModelDriven<Apply>{

	private Apply apply;
	private List<Apply> lrs;
	private ProbationDao pDao=new ProbationDao();
	private String key;
	
	
	/**
	 * 添加一条申请记录
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		pDao.add(apply);
		return "ret";
	}
	
	
	
	

	@Override
	public Apply getModel() {
		if(apply==null)
			apply=new Apply();
		else
			return apply;
		return apply;
	}
	
	
	
	/**
	 * 获取申请列表
	 * @return
	 * @throws Exception
	 */
	public String applist() throws Exception {
		setLrs(pDao.showApply());
		return "applylist";
	}
	
	public String select() throws Exception {
		lrs=pDao.selectApplyByKey("%"+key+"%");
		return "applylist";
	}
	
	/**
	 * 由ProbationAction的accept()方法跳转而来
	 * @return
	 * @throws Exception
	 */
	public String chain() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Probation pro=(Probation)request.getAttribute("pro");
		pDao.delById(pro.getPiid());
		return applist();
	}
	
	
	/**
	 * 删除申请表里的rid为appply.getRid()的一条信息
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		pDao.del(apply.getRid());
		return applist();
	}
	
	/**
	 * 找到一条申请记录，赋值给apply
	 * @return 
	 * @throws Exception
	 */
	public String accept() throws Exception {
		apply=pDao.find(apply.getRid());
		return "entry";
	}
	
	
	
	

	public Apply getApply() {
		return apply;
	}


	public void setApply(Apply apply) {
		this.apply = apply;
	}


	public List<Apply> getLrs() {
		return lrs;
	}


	public void setLrs(List<Apply> lrs) {
		this.lrs = lrs;
	}



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}
	
	
}

