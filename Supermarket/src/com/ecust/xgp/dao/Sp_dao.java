package com.ecust.xgp.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Sp;

public interface Sp_dao {
	void insert_sp(Sp sp) throws Exception;
	void insert_sp(Sp sp,Connection conn) throws Exception;
	List<Map<String,Object>> findAll_sp(String itemId) throws Exception;
	List<Map<String,Object>> findSpByName(String itemName) throws Exception;
	void delete_sp(String itemId);
	void update_sp(Sp sp) throws Exception;
	void update_sp(Sp sp,Connection conn) throws Exception;
}
