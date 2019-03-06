package com.ecust.xgp.service;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Jfsp;
import com.ecust.xgp.domain.Yhsp;

public interface Yhsp_service {
	/**
	 * 添加一条或多条商品信息
	 * @param spList
	 * @throws Exception 
	 */
	void addYhsp(List<Yhsp> yhspList) throws Exception;
	/**
	 * 删除一条或多条商品信息
	 * @param spIdList
	 * @throws Exception 
	 */
	void updateYhsp(List<Yhsp> yhspList) throws Exception;
	/**
	 * 查询库存商品
	 * return List<Map<String,Object>>
	 * @throws Exception 
	 */
	List<Map<String,Object>> findYhsp(String yhspId) throws Exception;
}
