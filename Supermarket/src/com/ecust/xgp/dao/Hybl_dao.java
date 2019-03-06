package com.ecust.xgp.dao;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Hybl;


public interface Hybl_dao {
	void insert_hybl(Hybl hybl) throws Exception;
	List<Map<String,Object>> findAll_hybl(String MemberId) throws Exception;
	void delete_hybl(String MemberId) throws Exception;
	void update_hybl(Hybl hybl) throws Exception;
}
