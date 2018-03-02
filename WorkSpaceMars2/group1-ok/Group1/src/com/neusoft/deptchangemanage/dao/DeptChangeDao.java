package com.neusoft.deptchangemanage.dao;

import java.util.List;

import com.neusoft.deptchangemanage.domain.DeptChange;
import com.neusoft.deptchangemanage.form.DeptChangeForm;
import com.neusoft.deptmanage.domain.Dept;
import com.neusoft.employeemanage.domain.All;
import com.neusoft.employeemanage.domain.Employee;
/**
 * �ӿڣ������˶����ݿ������Ա����������ط���
 * @author Clover
 *
 */
public interface DeptChangeDao {
		
	/**
	 *�����벿�ŵ�������>>Ա����Ϣ��ѯ>>ȷ��Ա������ҳ�棬�������ʱ���ø÷�����ʵ�ֶ�Ա�����ŵĵ���
	 */
	public abstract void addDeptChange(DeptChange deptchange);
	
	
	/**
	 * �����벿�ŵ�������>>�ѵ�������Ա����Ϣ��ѯҳ�棬�����ѯʱ���ø÷�����ʵ�����ݿ����Ե�������Ա���Ĳ�ѯ
	 * @return
	 */
	public abstract List<DeptChange> listDeptChange(All all);
	//public abstract List<DeptChange> listDeptChange(DeptChange deptChange);
	/**
	 * ��ò��Ų��ű��еĲ��ű�źͲ�������
	 */
	public abstract List<Dept> getDept_Name();
}
