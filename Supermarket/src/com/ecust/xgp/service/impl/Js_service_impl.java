package com.ecust.xgp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Gn_dao;
import com.ecust.xgp.dao.Js_dao;
import com.ecust.xgp.dao.Jsgn_dao;
import com.ecust.xgp.domain.Js;
import com.ecust.xgp.domain.Jsgn;
import com.ecust.xgp.service.Js_service;
import com.ecust.xgp.utils.DaoFactory;
import com.ecust.xgp.utils.NewId;

public class Js_service_impl implements Js_service {

	@Override
	public void addJs(Js js) throws Exception {
		Js_dao js_dao = DaoFactory.getJs_dao();
		/**
		 * 生成Id
		 */
		js.setRoleId("js"+NewId.getId());
		List<Map<String,Object>> list =js_dao.findAll_js(js.getRoleId());
		while(list != null && !list.isEmpty())
		{
			js.setRoleId("js"+NewId.getId());
			list=js_dao.findAll_js(js.getRoleId());
		}
		/**
		 * 插入
		 */
		js_dao.insert_js(js);
	}

	@Override
	public void deleteJs(String jsId) throws Exception {
		Js_dao js_dao = DaoFactory.getJs_dao();
		js_dao.delete_js(jsId);
	}

	@Override
	public void updateJs(Js js) throws Exception {
		Js_dao js_dao = DaoFactory.getJs_dao();
		js_dao.update_js(js);
	}

	@Override
	public List<Map<String, Object>> findJsById(String RoleId) throws Exception {
		Js_dao js_dao = DaoFactory.getJs_dao();
		return js_dao.findAll_js(RoleId);
	}
	/*
	 * 角色Id查功能
	 * @see com.ecust.xgp.service.Js_service#findGnByRoleId(java.lang.String)
	 */
	@Override
	public List<String> findGnByRoleId(String RoleId) throws Exception {
		Gn_dao gn_dao = DaoFactory.getGn_dao();
		Jsgn_dao jsgn_dao = DaoFactory.getJsgn_dao();
		List<String> gnList=new ArrayList<String>();
		/**
		 * 查找角色所有的功能Id
		 */
		List<Map<String,Object>> gnId=jsgn_dao.findAll_jsgn(RoleId, "");
		/**
		 * 找到功能Id对应的名字
		 */
		for (Map<String, Object> map : gnId) {
			/**
			 * 根据RoleId对应的GnId去功能表Gn查找对应的功能名称Id——Name
			 * RoleId对应的GnId=map.get(RoleId)
			 */
			List<Map<String,Object>> Id_Name=gn_dao.findAll_gn(map.get(RoleId).toString());
			/**
			 * 将功能名称添加进gnList
			 * map2.get(GnId)
			 */
			for (Map<String, Object> map2 : Id_Name) {
				gnList.add(map2.get(map.get(RoleId)).toString());
			}
		}
		return gnList;
	}
/*
 * 删除角色功能
 * @see com.ecust.xgp.service.Js_service#deleteJsGn(java.lang.String, java.lang.String)
 */
	@Override
	public void deleteJsGn(String RoleId, String OperationId) throws Exception {
		Jsgn_dao jsgn_dao = DaoFactory.getJsgn_dao();
		jsgn_dao.delete_jsgn(RoleId, OperationId);
	}
/**
 * 添加角色功能
 */
	@Override
	public void addJsGn(Jsgn jsgn) throws Exception {
		Jsgn_dao jsgn_dao = DaoFactory.getJsgn_dao();
		jsgn_dao.insert_jsgn(jsgn);
	}
	
}
