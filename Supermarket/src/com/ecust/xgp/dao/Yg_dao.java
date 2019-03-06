package com.ecust.xgp.dao;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Yg;

public interface Yg_dao {
	void Insert_Yg(Yg yg) throws Exception; 
	/*
	 * Id="%"查询所有
	 * Id=yg0001单体查询
	 */
	List<Map<String,Object>> findByYgAll(String Id) throws Exception;
	void delete_Yg(String Id);
	void update_Yg(Yg yg) throws Exception;
}
