package com.ecust.xgp.service.impl;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Jfsp_dao;
import com.ecust.xgp.domain.Jfsp;
import com.ecust.xgp.service.Jfsp_service;
import com.ecust.xgp.utils.DaoFactory;

public class Jfsp_service_impl implements Jfsp_service {

	@Override
	public void addJfsp(List<Jfsp> jfspList) throws Exception {
		Jfsp_dao jfsp_dao = DaoFactory.getJfsp_dao();
		for (Jfsp jfsp : jfspList) {
			jfsp_dao.insert_jfsp(jfsp);
		}
	}

	@Override
	public void deleteJfsp(List<String> spIdList) throws Exception {
		Jfsp_dao jfsp_dao = DaoFactory.getJfsp_dao();
		for (String  spId: spIdList) {
			jfsp_dao.delete_jfsp(spId);
		}
	}

	@Override
	public void updateJfsp(List<Jfsp> jfspList) throws Exception {
		Jfsp_dao jfsp_dao = DaoFactory.getJfsp_dao();
		for (Jfsp jfsp : jfspList) {
			jfsp_dao.update_jfsp(jfsp);
		}
	}

	@Override
	public List<Map<String, Object>> findJfsp(String jfspId) throws Exception {
		Jfsp_dao jfsp_dao = DaoFactory.getJfsp_dao();
		return jfsp_dao.findAll_jfsp(jfspId);
	}

}
