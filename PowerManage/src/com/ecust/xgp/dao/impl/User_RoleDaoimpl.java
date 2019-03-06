package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecust.xgp.dao.RoleDao;
import com.ecust.xgp.dao.UserDao;
import com.ecust.xgp.dao.User_RoleDao;
import com.ecust.xgp.domain.User_Role;

public class User_RoleDaoimpl implements User_RoleDao {

	@Override
	/*
	 * userid，rolename-》roleid
	 */
	public void addUser(int userid,String rolename) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try{
			RoleDao roledao=DaoFactory.getRoleDao();
			String sql="insert into user_role(userid,roleid) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, roledao.findByrolename(rolename).getRoleid());
			ps.executeUpdate();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				ps.close();
				conn.close();
			}catch(Exception e) {
				throw new RuntimeException();
			}
		}
		
	}

	@Override
	public void deleteUser(int userid) {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		String sql="delete from user_role where userid=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, userid);
		ps.executeUpdate();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	@Override
	public List<User_Role> findByUsername(String username) {
		UserDao userdao=DaoFactory.getUserdao();
		//找到username对应的编号
		int userid=userdao.findByusername(username).getUserid();
		List<User_Role> re = new ArrayList<User_Role>();
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet res=null;
		try {
			String sql="select* from user_role where userid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			res=ps.executeQuery();
			while(res.next()) {
				re.add(new User_Role(res.getInt("userid"),res.getInt("roleid")));
			}
			//
			return re;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				res.close();
				ps.close();
				conn.close();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
