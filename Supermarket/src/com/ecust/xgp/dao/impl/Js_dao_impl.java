package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Js_dao;
import com.ecust.xgp.domain.Js;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;

public class Js_dao_impl implements Js_dao {

	@Override
	public void insert_js(Js js) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into js(RoleId,RoleName) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, js.getRoleId());
			ps.setString(2, js.getRoleName());
			
			ps.executeUpdate();
			/*
			 * 提交事务
			 */
			conn.commit();
		}catch(Exception e) {
			/*
			 * 回滚事务
			 */
			conn.rollback();
			throw new RuntimeException();
		}finally {
			ps.close();
			conn.close();
		}

	}

	@Override
	public List<Map<String, Object>> findAll_js(String RoleId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from js where js.RoleId like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+RoleId+"%");
			re=ps.executeQuery();
			
			conn.commit();
			
			return CovertUtils.CovertList(re);
		}catch(Exception e) {
			conn.rollback();
			throw new RuntimeException();
		}finally {
			re.close();
			ps.close();
			conn.close();
		}
	}

	@Override
	public void delete_js(String RoleId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		String sql="delete from js where js.RoleId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, RoleId);
		ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update_js(Js js) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update js set js.RoleName=? where js.RoleId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, js.getRoleName());
		ps.setString(2, js.getRoleId());
		ps.executeUpdate();
		
		conn.commit();
		}catch(Exception e) {
			conn.rollback();
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
