package com.ecust.xgp.dao;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Jfsp;


public interface Jfsp_dao {
	void insert_jfsp(Jfsp jfsp) throws Exception;
	List<Map<String,Object>> findAll_jfsp(String ItemId) throws Exception;
	void delete_jfsp(String ItemId) throws Exception;
	void update_jfsp(Jfsp jfsp) throws Exception;
}
