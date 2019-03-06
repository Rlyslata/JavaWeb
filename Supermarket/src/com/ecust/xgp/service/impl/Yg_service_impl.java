package com.ecust.xgp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Yg_dao;
import com.ecust.xgp.dao.Ygrz_dao;
import com.ecust.xgp.dao.impl.Yg_dao_impl;
import com.ecust.xgp.domain.Yg;
import com.ecust.xgp.domain.Ygrz;
import com.ecust.xgp.service.Yg_service;
import com.ecust.xgp.utils.DaoFactory;
import com.ecust.xgp.utils.NewId;

public class Yg_service_impl implements Yg_service {

	@Override
	public void hireYg(Yg yg) throws Exception {
		Yg_dao yg_dao = DaoFactory.getYg_dao();
		/**
		 * 生成YgID
		 * 
		 * id符合完整性要求则插入
		 * 否则再重复shengchengId
		 */
		yg.setEmployeeId("yg"+NewId.getId());
		List<Map<String,Object>> list=yg_dao.findByYgAll(yg.getEmployeeId());
		//lis不为空，Id已存在，则继续创建Id
		while(list!=null && !list.isEmpty())
		{
			yg.setEmployeeId("yg"+NewId.getId());
			list=yg_dao.findByYgAll(yg.getEmployeeId());
		}
		/*
		 * 插入Yg表
		 */
		try {
			yg_dao.Insert_Yg(yg);
			
		}catch(Exception e) {
			System.out.println("插入失败");
		}
	}

	@Override
	public void fireYg(String id) {
		// TODO Auto-generated method stub
		Yg_dao_impl yg_dao = DaoFactory.getYg_dao();
		/**
		 * 删除员工
		 */
		yg_dao.delete_Yg(id);
	}
	
	@Override
	public List<Map<String, Object>> findYg(String Id) throws Exception {
		Yg_dao_impl yg_dao = DaoFactory.getYg_dao();
		return yg_dao.findByYgAll(Id);
	}

	@Override
	public void updateYg(Yg yg) throws Exception {
		Yg_dao_impl yg_dao = DaoFactory.getYg_dao();
		yg_dao.update_Yg(yg);
	}
	/*给员工添加角色
	 * EmployeeId 备操作的员工Id
	 * ROleId 要添加的角色
	 * 返回List<String>
	 */
	@Override
	public void addYgJs(Ygrz ygrz) throws Exception {
		Ygrz_dao ygrz_dao = DaoFactory.getYgrz_dao();
		ygrz_dao.insert_ygrz(ygrz);
	}
	/*
	 * 给员工删除角色
	 * Ygrz.EmployeeId 备操作的员工Id
	 * Ygrz.ROleId 要删除的角色
	 */
	@Override
	public void deleteYgJs(Ygrz ygrz) throws Exception {
		Ygrz_dao ygrz_dao = DaoFactory.getYgrz_dao();
		ygrz_dao.delete_ygrz(ygrz.getEmployeeId(), ygrz.getRoleId());
		
	}
	/*
	 * 查找员工角色ID
	 */
	@Override
	public List<String> findJsIdByYgId(String EmployeeId) throws Exception {
		Ygrz_dao ygrz_dao = DaoFactory.getYgrz_dao();
		/*
		 * 获得EmployeeId员工所具有的角色
		 */
		List<Map<String, Object>> listMap=ygrz_dao.findAll_ygrz(EmployeeId, "");
		List<String> listString=new ArrayList<String>();
		/*
		 * 将角色Id一次放入listString中
		 */
		for (Map<String, Object> map : listMap) {
			listString.add(map.get(EmployeeId).toString());
		}
		return listString;
	}

}
