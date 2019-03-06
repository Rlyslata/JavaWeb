package com.ecust.xgp.dao;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Jsgn;

public interface Jsgn_dao {
	void insert_jsgn(Jsgn jsgn) throws Exception;
	List<Map<String,Object>> findAll_jsgn(String RoleId,String OperationId) throws Exception;
	void delete_jsgn(String RoleId,String OperationId) throws Exception;
	void update_jsgn(Jsgn jsgn) throws Exception;
}
