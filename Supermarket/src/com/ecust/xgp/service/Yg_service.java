package com.ecust.xgp.service;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Yg;
import com.ecust.xgp.domain.Ygrz;

public interface Yg_service {
	void hireYg(Yg yg) throws Exception;
	void fireYg(String id);
	List<Map<String,Object>> findYg(String Id) throws Exception;
	void updateYg(Yg yg) throws Exception;
	
	/*给员工添加角色
	 * Ygrz.EmployeeId 备操作的员工Id
	 * Ygrz.ROleId 要添加的角色
	 * 返回List<String>
	 */
	void addYgJs(Ygrz ygrz) throws Exception;
	/*
	 * 给员工删除角色
	 * Ygrz.EmployeeId 备操作的员工Id
	 * Ygrz.ROleId 要删除的角色
	 */
	void deleteYgJs(Ygrz ygrz) throws Exception;
	/*
	 * 查找员工角色ID
	 */
	List<String> findJsIdByYgId(String EmployeeId) throws Exception;
}
