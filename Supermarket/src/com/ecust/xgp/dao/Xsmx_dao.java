package com.ecust.xgp.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Xsmx;


public interface Xsmx_dao {
	void insert_xsmx(Xsmx xsmx) throws Exception;
	void insert_xsmx(Xsmx xsmx,Connection conn) throws Exception;

	List<Map<String,Object>> findAll_xsmx(String SaleId,String ItemId) throws Exception;
	void delete_xsmx(String SaleId,String ItemId);
	void update_xsmx(Xsmx xsmx) throws Exception;
}
