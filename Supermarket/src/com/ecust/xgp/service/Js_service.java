package com.ecust.xgp.service;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Js;
import com.ecust.xgp.domain.Jsgn;

public interface Js_service {
	/*
	 * 添加角色
	 */
	void addJs(Js js) throws Exception;
	/*
	 * 删除角色
	 */
	void deleteJs(String jsId) throws Exception;
	/*
	 * 更改角色名称
	 */
	void updateJs(Js js) throws Exception;
	/*
	 * 根据Id查询角色
	 */
	List<Map<String,Object>> findJsById(String RoleId) throws Exception;
	/*
	List<Map<String,Object>> findJsByName()
	*/
	/*
	 * 根据角色Id查询功能
	 * 返回一个list<String>
	 */
	List<String> findGnByRoleId(String RoleId) throws Exception;
	/*
	 * 删除角色的功能
	 * 入口参数：角色Id，功能Id
	 */
	void deleteJsGn(String RoleId,String OperationId) throws Exception;
	void addJsGn(Jsgn jsgn) throws Exception;
}
