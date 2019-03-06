package com.ecust.xgp.service.impl;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ecust.xgp.dao.Hy_dao;
import com.ecust.xgp.dao.Jfsp_dao;
import com.ecust.xgp.dao.Sp_dao;
import com.ecust.xgp.dao.Xsd_dao;
import com.ecust.xgp.dao.Xsmx_dao;
import com.ecust.xgp.dao.Yhsp_dao;
import com.ecust.xgp.domain.Hy;
import com.ecust.xgp.domain.Xsd;
import com.ecust.xgp.domain.Xsmx;
import com.ecust.xgp.exception.HyIdErrorException;
import com.ecust.xgp.exception.IntegralNotEnoughException;
import com.ecust.xgp.exception.SpIdErrorException;
import com.ecust.xgp.service.Xs_service;
import com.ecust.xgp.utils.DaoFactory;
import com.ecust.xgp.utils.JdbcUtils;
import com.ecust.xgp.utils.NewId;

public class Xs_service_impl implements Xs_service {

	
	@Override
	public List<Map<String, Object>> findXsd(String SaleId) throws Exception {
		Xsd_dao xsd_dao = DaoFactory.getXsd_dao();
		return xsd_dao.findAll_xsd(SaleId);
	}

	@Override
	public List<Map<String, Object>> findXsmx(String SaleId, String ItemId) throws Exception {
		Xsmx_dao xsmx_dao = DaoFactory.getXsmx_dao();
		return xsmx_dao.findAll_xsmx(SaleId, ItemId);
	}
	/*
	 * 结算业务-现金结算
	 * 入口参数：商品类Sp对象及num，list<Map<>>，顾客Id
	 * 出口参数：结算总金额
	 * 1.Xsd表:插入一条新纪录
	 * 	
	 * 2.Xsmx表:插入一条或多条新纪录
	 * 
	 * 3.计算总金额
	 * 
	 * 4.给与会员积分
	 */
	@Override
	public int MoneyStatement(Map<String,Integer> SpMap, String CustomerNo,String EmployeeId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		
		Xsd_dao xsd_dao = DaoFactory.getXsd_dao();
		Xsmx_dao xsmx_dao = DaoFactory.getXsmx_dao();
		Hy_dao hy_dao=DaoFactory.getHy_dao();
		Yhsp_dao yhsp_dao = DaoFactory.getYhsp_dao();
		Sp_dao sp_dao = DaoFactory.getSp_dao();
	try {
			/*
			 * 关闭事物自动提交
			 */
		conn.setAutoCommit(false);	
		int totalMoney=0;//结算总金额
		/*
		 * 插入XSD
		 */
		Xsd xsd=new Xsd();
		xsd.setSaleld("xs"+NewId.getId());
		List<Map<String,Object>> list = xsd_dao.findAll_xsd(xsd.getSaleld());
		while(list != null && !list.isEmpty())
		{
			xsd.setSaleld("xs"+NewId.getId());
			list = xsd_dao.findAll_xsd(xsd.getSaleld());
		}
		xsd.setEmployeeId(EmployeeId);
		xsd.setCustomNo(CustomerNo);
		xsd.setSaleDate(new Date());
		
		xsd_dao.insert_xsd(xsd,conn);
		
		/*
		 * 插入XSMX
		 */
		
		//获取goumai商品Id
		Set<String> keySet = SpMap.keySet();
		Object[] spIds=keySet.toArray();//商品Id
		
		//查看会员顾客等级
		int MemberLevel=0;
		//hy的Map
		List<Map<String,Object>> hy = hy_dao.findAll_hy(CustomerNo);
		if(list!=null && list.size()==1)//list不为空，切大小为1，否则输入Id有误
		{
			for (Map<String, Object> map : hy) {
				if(map.get("MemberId").equals(CustomerNo))
					MemberLevel=Integer.parseInt(map.get("MemberLevel").toString());
				else
					throw new HyIdErrorException("ID有误，请重新输入会员ID");	
			}
		}
		else
		{
			throw new HyIdErrorException("ID有误，请重新输入会员ID");
		}
		
		for (Object spId : spIds) {
			Xsmx xsmx=new Xsmx();
			
			xsmx.setSaleId(xsd.getSaleld());
			xsmx.setItemId(spId.toString());
			xsmx.setSaleNum(SpMap.get(spId));
			
			/*
			 * 查看会员等级对应的discount
			 */
			float discount=0.0f;
			//检查该商品是否为优惠商品
			List<Map<String,Object>> yhspList = yhsp_dao.findAll_yhsp(spId.toString());
			if(yhspList!=null && yhspList.size()==1)
			{
				for (Map<String, Object> map : yhspList) {
					if(map.get("ItemId").equals(spId))
					{
						switch(MemberLevel)
						{
							case 0:discount=Float.parseFloat(map.get("FullCourtDiscount").toString());
							break;
							case 1:discount=Float.parseFloat(map.get("OneLevelDiscount").toString());
							break;
							case 2:	discount=Float.parseFloat(map.get("TwoLevelDiscount").toString());
							break;
							case 3:discount=Float.parseFloat(map.get("ThreeLevelDiscount").toString());
							break;
							default:break;
						}
					}
					else
					{
						throw new SpIdErrorException("商品Id有误，请重新输入");
					}
				}
			}
			else if(yhspList!=null && yhspList.size()==0)
			{
				List<Map<String,Object>> findAll_sp = sp_dao.findAll_sp(spId.toString());
				if(findAll_sp!=null && !findAll_sp.isEmpty())
					discount=0;////该商品不是优惠商品
				else
					throw new SpIdErrorException("商品Id有误，请重新输入");
			}
			else//查到了多个
			{
				throw new SpIdErrorException("商品Id有误，请重新输入");
			}
			
			/*
			 * 计算商品售价
			 */
			List<Map<String,Object>> sp_ToBuy = sp_dao.findAll_sp(spId.toString());
			float price=0;
			for (Map<String, Object> map : sp_ToBuy) {
				price=(Float)map.get("ItemPrice");
			}
			price=price*discount;
			xsmx.setSalePrice(price);
			xsmx.setSaleIntegral(0);
			xsmx_dao.insert_xsmx(xsmx,conn);
			
			totalMoney+=price;
		}
		/*
		 * 给予会员积分 单次满10元人民币=1积分
		 */
		int Intergral=totalMoney%10;
		
		if(MemberLevel>=1)//确定为会员
			{
				Hy hyObj = new Hy();
				for (Map<String, Object> map : hy) {
					hyObj.setMemberId(map.get("MemberId").toString());
					hyObj.setMemberName(map.get("MemberName").toString());
					hyObj.setHandleDate(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("HandleDate").toString()));
					hyObj.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("EndDate").toString()));
					hyObj.setMemeberLevel((Integer)map.get("MemberLevel"));
					Intergral+=(Integer)map.get("OwnIntergral");
					hyObj.setOwnIntegral(Intergral);
					hyObj.setTelephone(map.get("telephone").toString());
				}
				hy_dao.update_hy(hyObj,conn);
			}
		/*
		 * 结算业务 结束 提交事务
		 */
		conn.commit();
		return totalMoney;
		}catch(HyIdErrorException e) {
			conn.rollback();
			throw new HyIdErrorException("ID有误，请重新输入会员ID");
		}
		catch(SpIdErrorException e)
		{
			conn.rollback();
			throw new SpIdErrorException("商品Id有误，请重新输入");
		}finally {
			conn.close();
		}
	}
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
	@Override
	public int IntegralStatement(Map<String,Integer> SpMap, String CustomerNo,String EmployeeId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		
		Xsd_dao xsd_dao = DaoFactory.getXsd_dao();
		Xsmx_dao xsmx_dao = DaoFactory.getXsmx_dao();
		Hy_dao hy_dao=DaoFactory.getHy_dao();
		Jfsp_dao jfsp_dao = DaoFactory.getJfsp_dao();
		Sp_dao sp_dao = DaoFactory.getSp_dao();
		
		int totalIntergral=0;//结算总ji积分
			/*
			 * 关闭事物自动提交
			 */
		conn.setAutoCommit(false);	
		try {
			/*
			 * 插入XSD
			 */
		Xsd xsd=new Xsd();
		xsd.setSaleld("xs"+NewId.getId());
		List<Map<String,Object>> list = xsd_dao.findAll_xsd(xsd.getSaleld());
		while(list != null && !list.isEmpty())
		{
			xsd.setSaleld("xs"+NewId.getId());
			list = xsd_dao.findAll_xsd(xsd.getSaleld());
		}
		xsd.setEmployeeId(EmployeeId);
		xsd.setCustomNo(CustomerNo);
		xsd.setSaleDate(new Date());
		
		xsd_dao.insert_xsd(xsd,conn);
		/*
		 * 插入XSMX
		 */
		
		//获取goumai商品Id
		Set<String> keySet = SpMap.keySet();
		Object[] spIds=keySet.toArray();//商品Id
		
		//检查会员Id及查看会员积分
		int MemberIntegral=0;
		//hy的Map
		List<Map<String,Object>> hy = hy_dao.findAll_hy(CustomerNo);
		if(list!=null && list.size()==1)//list不为空，切大小为1，否则输入Id有误
		{
			for (Map<String, Object> map : hy) {
				if(map.get("MemberId").equals(CustomerNo))
					MemberIntegral=Integer.parseInt(map.get("OwnIntegral").toString());
				else
					throw new HyIdErrorException("ID有误，请重新输入会员ID");	
			}
		}
		else
		{
			throw new HyIdErrorException("ID有误，请重新输入会员ID");
		}
		
		for (Object spId : spIds) {
			Xsmx xsmx=new Xsmx();
			int NeededIntegral=0;
			
			xsmx.setSaleId(xsd.getSaleld());
			xsmx.setItemId(spId.toString());
			xsmx.setSaleNum(SpMap.get(spId));
			
			
			
			//检查该商品是否为积分商品
			List<Map<String,Object>> jfspList = jfsp_dao.findAll_jfsp(spId.toString());
			if(jfspList!=null && jfspList.size()==1)
			{
				for (Map<String, Object> map : jfspList) {
					if(map.get("ItemId").equals(spId))
					{
						/*
						 * 所需积分+
						 */
						NeededIntegral=Integer.valueOf(map.get("NeededIntegral").toString());
						
					}
					else
					{
						throw new SpIdErrorException("商品Id有误，请重新输入");
					}
				}
			}
			else if(jfspList!=null && jfspList.size()==0)
			{
				List<Map<String,Object>> findAll_sp = sp_dao.findAll_sp(spId.toString());
				if(findAll_sp!=null && !findAll_sp.isEmpty())
					throw new SpIdErrorException("该商品不是积分商品，请重新输入");
				else
					throw new SpIdErrorException("商品Id有误，请重新输入");
			}
			else//查到了多个
			{
				throw new SpIdErrorException("商品Id有误，请重新输入");
			}
			
			totalIntergral+=NeededIntegral;
			
			xsmx.setSalePrice(0);
			xsmx.setSaleIntegral(NeededIntegral);
			xsmx_dao.insert_xsmx(xsmx,conn);
		}
		/*
		 * 检查MemberIntegralShi否大于Totalintegral
		 */
		if(MemberIntegral>=totalIntergral)
		{
			Hy hyObj = new Hy();
			for (Map<String, Object> map : hy) {
				hyObj.setMemberId(map.get("MemberId").toString());
				hyObj.setMemberName(map.get("MemberName").toString());
				hyObj.setHandleDate(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("HandleDate").toString()));
				hyObj.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("EndDate").toString()));
				hyObj.setMemeberLevel((Integer)map.get("MemberLevel"));
				hyObj.setOwnIntegral(MemberIntegral-totalIntergral);
				hyObj.setTelephone(map.get("telephone").toString());
			}
			hy_dao.update_hy(hyObj,conn);
		}
		else
		{
			throw new IntegralNotEnoughException("会员积分不足");
		}
	
			
		/*
		 * 结算业务 结束 提交事务
		 */
		conn.commit();
		return totalIntergral;
	}catch(HyIdErrorException e) {
		conn.rollback();
		throw new HyIdErrorException(e.getMessage());
	}catch(SpIdErrorException e) {
		conn.rollback();
		throw new SpIdErrorException(e.getMessage());
	}catch(IntegralNotEnoughException e) {
		conn.rollback();
		throw new IntegralNotEnoughException(e.getMessage());
	}finally {
		conn.close();
	}
	}

}
