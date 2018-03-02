package com.kms.action;

import java.io.InputStream;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.struts2.ServletActionContext;

import com.kms.dao.ReportDao;
import com.kms.operation.ExcelOperation;
import com.kms.po.KeyWord;
import com.opensymphony.xwork2.ActionSupport;

/**报表生成的action处理类，
 * 
 * downloadType表示所下载报表的类型：
 * downloadType=1为实习生报表；
 * downloadType=2为在职员工报表；
 * downloadType=3为离职员工报表；
 * downloadType=4为指定日期范围的变更记录报表；
 * @author 刘嘉赓
 *
 */
public class ReportAction extends ActionSupport{
	private int downloadType=0;
	private String fileName;
	private KeyWord keyW = new KeyWord();
	
	String[] title = null;
	List<String []> list = null;
	ReportDao reportDao = new ReportDao();
	private ExcelOperation operation = new ExcelOperation();

	public InputStream getDownloadFile() throws Exception{
		System.out.println("----------------------------"+downloadType+"-------------------------------------------");
		if (downloadType == 1){				//下载实习生报表
			list = reportDao.listProbation();
			title = new String[] {"实习生编号","姓名","性别","年龄","学历","部门名称","岗位名称","实习开始时间","实习结束时间"};
			operation.writeExcel("H:\\TemptCode\\Java\\FinalProject\\WebContent\\report\\ProbationReport.xls", list, "实习生报表", title);
			
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {public void run() {}}, 1000);
			
			this.fileName = "ProbationReport.xls";
			this.fileName = new String(this.fileName.getBytes("GBK"),"UTF-8"); 
			InputStream is = ServletActionContext.getServletContext().getResourceAsStream("./report/ProbationReport.xls");
			System.out.println(is);
			return is;
		}else if (downloadType == 2){		//下载在职员工报表
			list = reportDao.listWorker();
			title = new String[] {"在职员工编号","姓名","性别","年龄","民族","籍贯","学历","部门名称","岗位名称","薪金","联系方式"};
			operation.writeExcel("H:\\TemptCode\\Java\\FinalProject\\WebContent\\report\\WorkerReport.xls", list, "在职员工报表", title);
			
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {public void run() {}}, 1500);
			
			this.fileName = "WorkerReport.xls";
			this.fileName = new String(this.fileName.getBytes("GBK"),"UTF-8"); 
			InputStream is = ServletActionContext.getServletContext().getResourceAsStream("./report/WorkerReport.xls");
			System.out.println(is);
			return is;
		}else if (downloadType == 3){		//下载离职员工报表
			list = reportDao.listQuit();
			title = new String[] {"离职员工编号","姓名","性别","年龄","民族","学历","部门名称","岗位名称","联系方式"};
			operation.writeExcel("H:\\TemptCode\\Java\\FinalProject\\WebContent\\report\\QuitReport.xls", list, "离职员工报表", title);
			
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {public void run() {}}, 1000);
			
			this.fileName = "QuitReport.xls";
			this.fileName = new String(this.fileName.getBytes("GBK"),"UTF-8"); 
			InputStream is = ServletActionContext.getServletContext().getResourceAsStream("./report/QuitReport.xls");
			System.out.println(is);
			return is;
		}else if (downloadType == 4){		//下载员工变更记录报表
			list = reportDao.listChange(keyW);
			title = new String[] {"记录编号","员工姓名","变更操作","原部门/岗位名称","现部门/岗位名称","原薪金","现薪金","变更时间"};
			operation.writeExcel("H:\\TemptCode\\Java\\FinalProject\\WebContent\\report\\ChangeReport.xls", list, "员工变更记录报表", title);
			
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {public void run() {}}, 2000);
			
			this.fileName = "ChangeReport.xls";
			this.fileName = new String(this.fileName.getBytes("GBK"),"UTF-8"); 
			InputStream is = ServletActionContext.getServletContext().getResourceAsStream("./report/ChangeReport.xls");
			System.out.println(is);
			return is;
		}else {
			return null;
		}
	}
	
	@Override  
    public String execute() throws Exception {  
        return SUCCESS;  
    }
//	获取下载报表类型
	public int getDownloadType() {
		return downloadType;
	}
//	设置下载报表类型
	public void setDownloadType(int downloadType) {
		this.downloadType = downloadType;
	}
//	获取下载文件名称
	public String getFileName() {
		return fileName;
	}
//	设置下载文件名称
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
