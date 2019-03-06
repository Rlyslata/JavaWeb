package com.ecust.xgp.dao;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Yhsp;


public interface Yhsp_dao {
	void insert_yhsp(Yhsp yhsp) throws Exception;
	List<Map<String,Object>> findAll_yhsp(String ItemId) throws Exception;
	void delete_yhsp(String ItemId) throws Exception;
	void update_yhsp(Yhsp yhsp) throws Exception;
}
