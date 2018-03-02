package com.neusoft.code.dao;

import java.util.List;

import com.neusoft.code.domain.Code;

public interface CodeDao {
	
	public abstract List<Code> getCode(int type_id);
	
}
