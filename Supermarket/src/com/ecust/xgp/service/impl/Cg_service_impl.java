package com.ecust.xgp.service.impl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Cgd_dao;
import com.ecust.xgp.dao.Cgmx_dao;
import com.ecust.xgp.dao.Gys_dao;
import com.ecust.xgp.dao.Sp_dao;
import com.ecust.xgp.domain.Cgd;
import com.ecust.xgp.domain.Cgmx;
import com.ecust.xgp.domain.Sp;
import com.ecust.xgp.exception.NumberErrorException;
import com.ecust.xgp.exception.gysNotFoundException;
import com.ecust.xgp.service.Cg_service;
import com.ecust.xgp.utils.DaoFactory;
import com.ecust.xgp.utils.JdbcUtils;
import com.ecust.xgp.utils.NewId;

public class Cg_service_impl implements Cg_service {

	public Cg_service_impl() {
	
	}
	/*
	 * 添加采购单
	 * 1.插入新的采购单CGD(只能从在册的供应商那里采购)
	 * 
	 * 2.插入新的采购明细
	 * 
	 * 3.插入新的商品
	 * 
	 * 
	 * 
	 * 入口参数：
	 *商品的名称，商品的个数，单位，采购价格，供应商对象,采购员工Id
	 * 
	 */
	@Override
	public void addCgd(String spName, int spNum,String pcs, float price, String gysId,String EmployeeId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		try {
		conn.setAutoCommit(false);
		if(spNum<=0)
		{
			throw new NumberErrorException("采购的商品数量至少大于一");
		}
		
		/*
		 * 插入新的商品
		 */
		Sp_dao sp_dao = DaoFactory.getSp_dao();
		Gys_dao gys_dao = DaoFactory.getGys_dao();
		Cgd_dao cgd_dao = DaoFactory.getCgd_dao();
		Cgmx_dao cgmx_dao = DaoFactory.getCgmx_dao();
		
		List<Map<String,Object>> gyslist = gys_dao.findAll_gys(gysId);
		if(gyslist!=null && gyslist.isEmpty())
		{
			throw new gysNotFoundException("供应商不存在，只能从在册的供应商处采购");
		}
		Sp new_Sp=new Sp();
		new_Sp.setItemName(spName);
		new_Sp.setItemSize(pcs);
		new_Sp.setProvider(gysId);
		new_Sp.setInventory(spNum);
		/*
		 * 999999标识未开售
		 */
		new_Sp.setItemPrice(999999);
		List<Map<String,Object>> list = sp_dao.findSpByName(spName);
		if(list !=null && !list.isEmpty()&&list.size()==1)
		{
			for (Map<String, Object> map : list) {
				if(map.get("ItemName").equals(new_Sp.getItemName()) && 
						map.get("ItemSize").equals(new_Sp.getItemSize()) &&
							map.get("provider").equals(new_Sp.getProvider()) &&
								map.get("Inventory").equals(new_Sp.getInventory())
				)
				{
					//合并相同商品
					new_Sp.setItemId(map.get("ItemId").toString());
					new_Sp.setItemPrice(Float.parseFloat(map.get("ItemPrice").toString()));
					sp_dao.update_sp(new_Sp,conn);
				}
				else
				{
					//不同则插入新商品
					new_Sp.setItemId("sp"+NewId.getId());
					/*
					 * 检查Id是否已存在
					 */
					List<Map<String,Object>> splist = sp_dao.findAll_sp(new_Sp.getItemId());
					/*
					 * 已存在则再次生成Id知道
					 */
					while(list!=null && !splist.isEmpty())
					{
						new_Sp.setItemId("sp"+NewId.getId());
						list = sp_dao.findAll_sp(new_Sp.getItemId());
					}
					sp_dao.insert_sp(new_Sp,conn);
				}
			}
			
		}
		else {
			//不同则插入新商品
			new_Sp.setItemId("sp"+NewId.getId());
			/*
			 * 检查Id是否已存在
			 */
			List<Map<String,Object>> splist = sp_dao.findAll_sp(new_Sp.getItemId());
			/*
			 * 已存在则再次生成Id知道
			 */
			while(list!=null && !splist.isEmpty())
			{
				new_Sp.setItemId("sp"+NewId.getId());
				list = sp_dao.findAll_sp(new_Sp.getItemId());
			}
			sp_dao.insert_sp(new_Sp,conn);
		}
//	/*
//	 * 插入供应商
//	 */
//	if(gys.getProviderId()==null)
//	{
//		gys.setProviderId("gy"+NewId.getId());
//		/*
//		 * 检查Id是否已存在
//		 */
//		List<Map<String,Object>> gyslist = gys_dao.findAll_gys(gys.getProviderId());
//		/*
//		 * 已存在则再次生成Id知道
//		 */
//		while(list!=null && !gyslist.isEmpty())
//		{
//			gys.setProviderId("gy"+NewId.getId());
//			gyslist = gys_dao.findAll_gys(gys.getProviderId());
//		}
//		gys_dao.insert_gys(gys);
//	}
	/*
	 * 插入采购单
	 */
	Cgd New_cgd = new Cgd();
	New_cgd.setEmployeeId(EmployeeId);
	New_cgd.setProviderId(gysId);
	New_cgd.setPurchaseDate(new Date());
	
	New_cgd.setPurchaseId("cg"+NewId.getId());
	List<Map<String,Object>> findAll_cgd = cgd_dao.findAll_cgd(New_cgd.getPurchaseId());
	while(findAll_cgd!=null && !findAll_cgd.isEmpty())
	{
		New_cgd.setPurchaseId("cg"+NewId.getId());
		findAll_cgd = cgd_dao.findAll_cgd(New_cgd.getPurchaseId());
	}
	
	cgd_dao.insert_cgd(New_cgd,conn);
	
	
	/*
	 *插入采购明细 
	 */
	Cgmx cgmx = new Cgmx();
	cgmx.setPurchaseId(New_cgd.getPurchaseId());
	cgmx.setItemId(new_Sp.getItemId());
	cgmx.setPrice(price);
	cgmx.setQuantity(spNum);
	
	cgmx_dao.insert_cgmx(cgmx,conn);
	conn.commit();
		}catch(NumberErrorException e) {
			conn.rollback();
			throw new NumberErrorException(e.getMessage());
		}catch(gysNotFoundException e) {
			conn.rollback();
			throw new gysNotFoundException(e.getMessage());
		}
		catch(Exception e) {
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	@Override
	public List<Map<String, Object>> findCgd(String CgdId) throws Exception {
		Cgd_dao cgd_dao = DaoFactory.getCgd_dao();
		return cgd_dao.findAll_cgd(CgdId);
	}

}
