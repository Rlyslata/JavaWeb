package com.ecust.xgp.dao;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Gn;

public interface Gn_dao {
	void insert_gn(Gn gn) throws Exception;
	List<Map<String,Object>> findAll_gn(String OperationId) throws Exception;
	void delete_gn(String OperationId);
	void update_gn(Gn gn) throws Exception;
}
