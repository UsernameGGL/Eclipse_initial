package com.kms.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kms.dao.ProbationDao;
import com.kms.po.Probation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 封装probationinfo表的操作
 * public String list() 获取实习生列表
 * public String accept() 添加一条实习生记录
 * public String delay()  实习期延长
 * public String positive() 实习生转正
 * public String reject() 辞退实习生
 * 
 * @author 张金海
 *
 */
public class ProbationAction extends ActionSupport implements ModelDriven<Probation> {


	private Probation pro;
	private List<Probation> pl;
	private ProbationDao pDao=new ProbationDao();
	private String delayDay;
	private String key;
	
	@Override
	public Probation getModel() {
		if(pro==null)
			pro=new Probation();
		else
			return pro;
		return pro;
	}
	
	
	public String select() throws Exception {
		pl=pDao.selectProbationByKey("%"+key+"%");
		return "prolist";
	}
	
	/**
	 * 获取实习生列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		setPl(pDao.showProbation());
		return "prolist";
	}
	
	
	/**
	 * 添加一条实习生信息记录，返回实习生列表
	 * @return 
	 * @throws Exception
	 */
	public String accept() throws Exception {
		pDao.addToProbation(pro);
		HttpServletRequest req=(HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		req.setAttribute("pro", pro);
		return "chain";
	}
	
	/**
	 * 延长实习生实习期
	 * @return
	 * @throws Exception
	 */
	public String delay() throws Exception {
		pDao.delay(pro.getPid(),Integer.parseInt(getDelayDay()));
		return list();
	}
	
	
	/**
	 * 将实习生转正，将信息保存到正式职员中
	 * @return
	 * @throws Exception
	 */
	public String positive() throws Exception {
		pro=pDao.findProbation(pro.getPid());
		pDao.addToJobinfo(pro);
		pDao.addToWorkerinfo(pro);
		pDao.delProbation(pro.getPid());
		return list();
	}
	
	
	/**
	 * 辞退实习生
	 * @return
	 * @throws Exception
	 */
	public String reject() throws Exception {
		pDao.delProbation(pro.getPid());
		return list();
	}
	
	


	public ProbationDao getpDao() {
		return pDao;
	}


	public void setpDao(ProbationDao pDao) {
		this.pDao = pDao;
	}

	public List<Probation> getPl() {
		return pl;
	}

	public void setPl(List<Probation> pl) {
		this.pl = pl;
	}


	public String getDelayDay() {
		return delayDay;
	}


	public void setDelayDay(String delayDay) {
		this.delayDay = delayDay;
	}
	
}