package com.ecust.xgp.service;

import java.util.List;
import java.util.Map;

public interface Cg_service {
	/*
	 * 添加采购单
	 * 1.插入新的采购单CGD
	 * 
	 * 2.插入新的采购明细
	 * 
	 * 3.插入新的商品
	 * 
	 * 4.插入新的供应商
	 * 
	 * 入口参数：
	 *商品的名称，商品的个数，单位，采购价格，供应商对象
	 * 
	 */
	void addCgd(String spName, int spNum,String pcs, float price,String gysId,String EmployeeId) throws Exception;
	/*
	 * 查询采购记录
	 */
	List<Map<String,Object>> findCgd(String CgdId) throws Exception;
}
