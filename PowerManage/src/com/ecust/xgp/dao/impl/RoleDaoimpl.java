package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ecust.xgp.dao.RoleDao;
import com.ecust.xgp.domain.Role;

public class RoleDaoimpl implements RoleDao {
	@Override
	public Role findByrolename(String rolename) {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet res;
		try{
			String sql="select * from role where rolename=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, rolename);
			res = ps.executeQuery();
			while(res.next()) {
				return new Role(res.getInt("roleid"),res.getString("rolename"));
			}
			return null;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try{
				ps.close();
				conn.close();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
