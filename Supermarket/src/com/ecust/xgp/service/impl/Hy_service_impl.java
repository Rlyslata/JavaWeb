package com.ecust.xgp.service.impl;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Hy_dao;
import com.ecust.xgp.dao.Hybl_dao;
import com.ecust.xgp.domain.Hy;
import com.ecust.xgp.service.Hy_service;
import com.ecust.xgp.utils.DaoFactory;
import com.ecust.xgp.utils.NewId;

public class Hy_service_impl implements Hy_service {

	@Override
	public void addHy(List<Hy> hy) throws Exception {
		Hy_dao hy_dao = DaoFactory.getHy_dao();
		for (Hy hy2 : hy) {
			hy2.setMemberId("hy"+NewId.getId());
			List<Map<String,Object>> list = hy_dao.findAll_hy(hy2.getMemberId());
			while(list!=null && !list.isEmpty())
			{
				hy2.setMemberId("hy"+NewId.getId());
				list = hy_dao.findAll_hy(hy2.getMemberId());
			}
			hy_dao.insert_hy(hy2);
		}
		

	}
	/**
	 * 返回会员信息，以及会员办理人Id
	 * @throws Exception 
	 */
	@Override
	public List<Map<String, Object>> findHy(String hyId) throws Exception {
		Hy_dao hy_dao=DaoFactory.getHy_dao();
		List<Map<String,Object>> hyList=hy_dao.findAll_hy(hyId);
		/**
		 * 对查询的会员Map进行补充，加入办理人
		 */
		Hybl_dao hybl_dao = DaoFactory.getHybl_dao();
		for (Map<String, Object> map : hyList) {
			/*
			 * 通过会员Id查找会员办理人
			 */
			List<Map<String,Object>> hyblList = hybl_dao.findAll_hybl(map.get("MemberId").toString());
			
			for (Map<String, Object> map2 : hyblList) {
				map.put("EmployeeId",map2.get("EmployeeId"));
			}
		}
		return hyList;
	}

}
