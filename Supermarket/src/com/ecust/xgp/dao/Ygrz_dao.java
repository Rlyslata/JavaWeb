package com.ecust.xgp.dao;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Ygrz;

public interface Ygrz_dao {
	void insert_ygrz(Ygrz ygrz) throws Exception;
	List<Map<String,Object>> findAll_ygrz(String EmployeeId,String RoleId) throws Exception;
	void delete_ygrz(String EmployeeId,String RoleId) throws Exception;
	void update_ygrz(Ygrz ygrz) throws Exception;
}
