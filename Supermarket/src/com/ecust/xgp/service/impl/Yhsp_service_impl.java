package com.ecust.xgp.service.impl;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Yhsp_dao;
import com.ecust.xgp.domain.Yhsp;
import com.ecust.xgp.service.Yhsp_service;
import com.ecust.xgp.utils.DaoFactory;

public class Yhsp_service_impl implements Yhsp_service {

	@Override
	public void addYhsp(List<Yhsp> yhspList) throws Exception {
		Yhsp_dao yhsp_dao = DaoFactory.getYhsp_dao();
		for (Yhsp yhsp : yhspList) {
			yhsp_dao.insert_yhsp(yhsp);
		}
	}

	@Override
	public void updateYhsp(List<Yhsp> yhspList) throws Exception {
		Yhsp_dao yhsp_dao = DaoFactory.getYhsp_dao();
		for (Yhsp  yhsp: yhspList) {
			yhsp_dao.update_yhsp(yhsp);
		}
		
	}

	@Override
	public List<Map<String, Object>> findYhsp(String yhspId) throws Exception {
		Yhsp_dao yhsp_dao = DaoFactory.getYhsp_dao();
		return yhsp_dao.findAll_yhsp(yhspId);
	}
	
}
