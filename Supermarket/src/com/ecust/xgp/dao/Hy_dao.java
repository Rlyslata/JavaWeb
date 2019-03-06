package com.ecust.xgp.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Hy;

public interface Hy_dao {
	void insert_hy(Hy hy) throws Exception;
	void insert_hy(Hy hy,Connection conn) throws Exception;

	List<Map<String,Object>> findAll_hy(String memberid) throws Exception;
	void delete_hy(String memberid);
	void update_hy(Hy hy) throws Exception;
	void update_hy(Hy hy,Connection conn) throws Exception;
}
