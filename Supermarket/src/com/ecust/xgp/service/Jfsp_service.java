package com.ecust.xgp.service;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Jfsp;

public interface Jfsp_service {
	/**
	 * 添加一条或多条商品信息
	 * @param spList
	 * @throws Exception 
	 */
	void addJfsp(List<Jfsp> jfspList) throws Exception;
	/**
	 * 删除一条或多条商品信息
	 * @param spIdList
	 * @throws Exception 
	 */
	void deleteJfsp(List<String> spIdList) throws Exception;
	/**
	 * 更新商品信息一条或多条
	 * @throws Exception 
	 */
	void updateJfsp(List<Jfsp> jfspList) throws Exception;
	/**
	 * 查询库存商品
	 * return List<Map<String,Object>>
	 * @throws Exception 
	 */
	List<Map<String,Object>> findJfsp(String jfspId) throws Exception;
}
