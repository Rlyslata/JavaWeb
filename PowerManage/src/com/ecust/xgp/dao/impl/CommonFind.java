package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class CommonFind {
	/**
	 *  查找id为userid的用户的所有角色,及所由角色具有的操作
	 * @param userid
	 * @return List<Map<String,Object>>
	 * @throws Exception
	 */
	public static List<Map<String,Object>> findByUserid(int userid) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet reset=null;
		String sql=null;
		List<Map<String,Object>> relist=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql1="select a.userid,b.roleid,b.rolename,c.sysopid,d.sysopname  ";
			String sql2="from user_role as a,role as b,role_sysop as c,sysop as d   ";
			String sql3="where a.roleid=b.roleid and b.roleid=c.roleid and   ";
			String sql4="c.sysopid=d.sysopid and  a.userid=?    ";
			sql=sql1+sql2+sql3+sql4;
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			reset=ps.executeQuery();
			relist=CovertUtils.CovertList(reset);
			return relist;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			ps.close();
			conn.close();
		}
	}
}
