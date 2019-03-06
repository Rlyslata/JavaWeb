package com.ecust.xgp.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Xsd;

public interface Xsd_dao {
	void insert_xsd(Xsd xsd) throws Exception;
	void insert_xsd(Xsd xsd,Connection conn) throws Exception;

	List<Map<String,Object>> findAll_xsd(String Id) throws Exception;
	void delete_xsd(String Id);
	void update_Xsd(Xsd xsd) throws Exception;
}
