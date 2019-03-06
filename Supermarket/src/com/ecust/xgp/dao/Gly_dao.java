package com.ecust.xgp.dao;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Gly;

public interface Gly_dao {
	void insert_gly(Gly gly) throws Exception;
	List<Map<String,Object>> findAll_gly(String AdminId) throws Exception;
	void delete_gly(String AdminId) throws Exception;
	void update_gly(Gly gly) throws Exception;
}
