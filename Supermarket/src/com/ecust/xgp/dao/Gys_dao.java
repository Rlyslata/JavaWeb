package com.ecust.xgp.dao;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Gys;


public interface Gys_dao {
	void insert_gys(Gys gys) throws Exception;
	List<Map<String,Object>> findAll_gys(String ProviderId) throws Exception;
	void delete_gys(String ProviderId) throws Exception;
	void update_gys(Gys gys) throws Exception;
}
