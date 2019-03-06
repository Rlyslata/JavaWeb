package com.ecust.xgp.service;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Sp;

public interface SpKc_service {
	/**
	 * 添加一条或多条商品信息
	 * @param spList
	 * @throws Exception 
	 */
	void addSp(List<Sp> spList) throws Exception;
	/**
	 * 删除一条或多条商品信息
	 * @param spIdList
	 */
	void deleteSp(List<String> spIdList);
	/**
	 * 更新商品信息一条或多条
	 * @throws Exception 
	 */
	void updateSp(List<Sp> spList) throws Exception;
	/**
	 * 查询库存商品
	 * return List<Map<String,Object>>
	 * @throws Exception 
	 */
	List<Map<String,Object>> findSp(String spId) throws Exception;
}
