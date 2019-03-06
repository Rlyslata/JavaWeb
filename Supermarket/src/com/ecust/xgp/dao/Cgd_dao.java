package com.ecust.xgp.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Cgd;

public interface Cgd_dao {
	void insert_cgd(Cgd cgd) throws Exception;
	void insert_cgd(Cgd cgd,Connection conn) throws Exception;
	List<Map<String,Object>> findAll_cgd(String PurchaseId) throws Exception;
	void delete_cgd(String PurchaseId) throws Exception;
	void update_cgd(Cgd cgd) throws Exception;
}
