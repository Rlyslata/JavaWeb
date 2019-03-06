package com.ecust.xgp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.impl.CommonFind;
import com.ecust.xgp.dao.impl.JdbcUtils;
import com.ecust.xgp.exception.NoPower;
import com.ecust.xgp.service.PowerCheckService;

public class PowerCheckServiceimpl implements PowerCheckService {

	@Override
	public void AddUserCheckService(int currentUserid) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet res=null;
		boolean flag=false;
		String sql="select distinct sysopname from user_role as a,role_sysop as b,sysop as c where a.roleid=b.roleid and b.sysopid=c.sysopid and a.userid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, currentUserid);
			res= ps.executeQuery();
			while(res.next()) {
				if(res.getString("sysopname").equals("adduser"))
					{
						flag=true;break;//有adduser权限
					}
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			res.close();
			ps.close();
			conn.close();
			if(flag==false) {
				throw new NoPower("您不能进行此操作");
			}
		}
	}

	@Override
	public boolean superCheckServiceWithException(int userid) throws Exception {
		List<Map<String,Object>> list=CommonFind.findByUserid(userid);
		for(Map<String,Object> map:list) {
			if("supermanager".equals(map.get("rolename")))
			{
				return true;
			}
		}
		throw new NoPower("您不是，supermanager");
	}

	@Override
	public boolean managerCheckServiceWithException(int userid) throws Exception {
		List<Map<String,Object>> list=CommonFind.findByUserid(userid);
		for(Map<String,Object> map:list) {
			if("manager".equals(map.get("rolename")))
			{
				return true;
			}
		}
		throw new NoPower("您不是，manager");
	}
	@Override
	public boolean generalCheckServiceWithException(int userid)throws Exception{
		List<Map<String,Object>> list=CommonFind.findByUserid(userid);
		for(Map<String,Object> map:list) {
			if("general".equals(map.get("rolename")))
			{
				return true;
			}
		}
		throw new NoPower("您不是，general");
	}

	@Override
	public boolean superCheckService(int userid) {
		List<Map<String, Object>> list=null;
		try {
			list = CommonFind.findByUserid(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Map<String,Object> map:list) {
			if("supermanager".equals(map.get("rolename")))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean managerCheckService(int userid){
		List<Map<String, Object>> list=null;
		try {
			list = CommonFind.findByUserid(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Map<String,Object> map:list) {
			if("manager".equals(map.get("rolename")))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean generalCheckService(int userid){
		List<Map<String, Object>> list=null;
		try {
			list = CommonFind.findByUserid(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Map<String,Object> map:list) {
			if("general".equals(map.get("rolename")))
			{
				return true;
			}
		}
		return false;
	}
}
