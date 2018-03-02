package com.kms.pojo;
/**
 * 持久化对象类
 * 类名和表名一致，属性名和列名一致
 * 在给表和列命名的过程中，必须考虑Java和sql的关键字冲突问题
 * @author 12515
 *
 */
public class Worker {
	private int workerNo;
	private int deptNo;
	private int jobNo;
	
	public int getWorkerNo() {
		return workerNo;
	}
	public void setWorkerNo(int workerNo) {
		this.workerNo = workerNo;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getJobNo() {
		return jobNo;
	}
	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}
	
}
