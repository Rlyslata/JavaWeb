package com.ecust.xgp.service.impl;

import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Gly_dao;
import com.ecust.xgp.dao.Yg_dao;
import com.ecust.xgp.exception.LoginErrorException;
import com.ecust.xgp.service.CheckService;
import com.ecust.xgp.utils.DaoFactory;

public class CheckService_impl implements CheckService{

	/*
	 * 检查账号密码
	 * @see com.ecust.xgp.service.CheckService#LoginCheck(java.lang.String)
	 */
	@Override
	public boolean LoginCheck(String userId,String password) throws Exception {
		Yg_dao yg_dao = DaoFactory.getYg_dao();
		List<Map<String,Object>> ygAll = yg_dao.findByYgAll(userId);
		Gly_dao gly_dao = DaoFactory.getGly_dao();
		List<Map<String,Object>> all_gly = gly_dao.findAll_gly(userId);
		if(ygAll!=null && !ygAll.isEmpty() && ygAll.size()==1)//查到有记录,yg
		{
			for (Map<String, Object> map : ygAll) {
				if(map.get("EmployeeId").equals(userId) && map.get("EmployeePassword").equals(password))
				{
					return true;
				}
				else
				{
					throw new LoginErrorException("账号或密码错误，请检查账号和密码是否正确！");
				}
			}
		}
		else if(all_gly!=null && !all_gly.isEmpty() && all_gly.size()==1)//yg没有再检查gyl
		{
			for (Map<String, Object> map : all_gly) {
				if(map.get("AdminId").equals(userId) && map.get("AdminName").equals(password))
				{
					return true;
				}
				else
				{
					throw new LoginErrorException("账号或密码错误，请检查账号和密码是否正确！");
				}
			}
		}
		else
		{
			throw new LoginErrorException("账号或密码错误，请检查账号和密码是否正确！");
		}
		return false;
	}

	@Override
	public boolean GnCheck(List<String> gnList,String currentGn) {
		for (String all_gn : gnList) {
			if(all_gn.equals(currentGn))
			{
				return true;
			}
		}
		return false;
	} 

}
