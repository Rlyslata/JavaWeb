package com.ecust.xgp.service;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.domain.Sp;
// TODO
public interface Xs_service {
	/*
	 * 结算业务-现金结算
	 * 入口参数：商品ID，购买数量，顾客Id，EmployeeId
	 * 出口参数：结算总金额
	 * 1.Xsd表:插入一条新纪录
	 * 	
	 * 2.Xsmx表:插入一条或多条新纪录
	 * 
	 * 3.计算总金额
	 * 
	 * 4.给与会员积分
	 */
	int MoneyStatement(Map<String,Integer> SpMap,String CustomerNo,String EmployeeId) throws Exception;
	/*
	 * 结算业务-积分结算
	 * 入口参数：商品ID，购买数量，顾客Id，EmployeeId
	 * 出口参数：结算总金额
	 * 1.Xsd表:插入一条新纪录
	 * 	
	 * 2.Xsmx表:插入一条或多条新纪录
	 * 
	 * 3.计算总积分
	 * 
	 * 4.扣除积分
	 */
	int IntegralStatement(Map<String,Integer> SpMap,String CustomerNo,String EmployeeId) throws Exception;
	/*
	 * 查询销售单
	 */
	List<Map<String,Object>> findXsd(String SaleId) throws Exception;
	/*
	 * 查询销售明细
	 */
	List<Map<String,Object>> findXsmx(String SaleId, String ItemId) throws Exception;
}
