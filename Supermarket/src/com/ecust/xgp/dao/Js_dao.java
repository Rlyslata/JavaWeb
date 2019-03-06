package com.ecust.xgp.dao;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Js;


public interface Js_dao {
	void insert_js(Js js) throws Exception;
	List<Map<String,Object>> findAll_js(String RoleId) throws Exception;
	void delete_js(String RoleId) throws Exception;
	void update_js(Js js) throws Exception;
}
