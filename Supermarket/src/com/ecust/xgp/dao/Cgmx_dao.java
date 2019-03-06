package com.ecust.xgp.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Cgmx;

public interface Cgmx_dao {
	void insert_cgmx(Cgmx cgmx) throws Exception;
	void insert_cgmx(Cgmx cgmx,Connection conn) throws Exception;
	List<Map<String,Object>> findAll_cgmx(String PurchaseId,String ItemId) throws Exception;
	void delete_cgmx(String PurchaseId,String ItemId) throws Exception;
	void update_cgmx(Cgmx cgmx) throws Exception;
}
