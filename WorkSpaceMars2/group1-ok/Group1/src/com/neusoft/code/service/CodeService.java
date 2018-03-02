package com.neusoft.code.service;

import java.sql.Connection;
import java.util.List;

import com.neusoft.code.dao.CodeDaoImpl;
import com.neusoft.code.domain.Code;

import devoid.frame.business.DBUtils;
import devoid.frame.business.ServiceException;



public class CodeService {
//	private  CodeService instance;
//	private void setInstance( CodeService instance){
//		this.instance = instance;
//	}
	private static CodeService instance = new CodeService();
	
	public static CodeService getInstance(){
		return instance;
	}
	
	private CodeService(){
		
	}
	public List<Code> getCode(int type_id){
		List<Code> list = null;
		Connection conn = null;
		try{
			//��ȡ���ݿ�����
			conn = DBUtils.getConnection();
			//����dao������
			CodeDaoImpl codedaoimpl = new CodeDaoImpl(conn);
			//����dao�㷽��
			list = codedaoimpl.getCode(type_id);
			return list;
		}catch(ServiceException s){
			throw s;  
		}catch(Exception e){
			throw new ServiceException("Error on getting code");
		}finally{
			
			DBUtils.closeConnection(conn);
		}
		
	}

}
