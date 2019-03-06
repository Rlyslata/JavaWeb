package com.ecust.xgp.service.impl;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Sp_dao;
import com.ecust.xgp.domain.Sp;
import com.ecust.xgp.service.SpKc_service;
import com.ecust.xgp.utils.DaoFactory;
import com.ecust.xgp.utils.NewId;

public class SpKc_service_impl implements SpKc_service {

	@Override
	public void addSp(List<Sp> spList) throws Exception {
		Sp_dao sp_dao = DaoFactory.getSp_dao();
		/**
		 * 变量类型Sp
		 * 遍历对象 spList
		 * 给sp2生成Id
		 */
		for (Sp sp2 : spList) {
			/*
			 * 生成sp+0001
			 */
			sp2.setItemId("sp"+NewId.getId());
			/*
			 * 检查Id是否已存在
			 */
			List<Map<String,Object>> list = sp_dao.findAll_sp(sp2.getItemId());
			/*
			 * 已存在则再次生成Id知道
			 */
			while(list!=null && !list.isEmpty())
			{
				sp2.setItemId("sp"+NewId.getId());
				list = sp_dao.findAll_sp(sp2.getItemId());
			}
			sp_dao.insert_sp(sp2);
		}
		
	}

	@Override
	public void deleteSp(List<String> spIdList) {
		Sp_dao sp_dao = DaoFactory.getSp_dao();
		
		for (String spId : spIdList) {
			sp_dao.delete_sp(spId);
		}
	}

	@Override
	public void updateSp(List<Sp> spList) throws Exception {
		Sp_dao sp_dao = DaoFactory.getSp_dao();
		for(Sp sp2: spList) {
			sp_dao.update_sp(sp2);
		}
	}

	@Override
	public List<Map<String, Object>> findSp(String spId) throws Exception {
		Sp_dao sp_dao = DaoFactory.getSp_dao();
		return sp_dao.findAll_sp(spId);
	}

}
