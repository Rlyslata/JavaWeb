package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Gly_dao;
import com.ecust.xgp.domain.Gly;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;

public class Gly_dao_impl implements Gly_dao{

	@Override
	public void insert_gly(Gly gly) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into gly(AdminId,AdminName) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, gly.getAdminId());
			ps.setString(2, gly.getAdminName());
			
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
	public List<Map<String, Object>> findAll_gly(String AdminId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from gly where gly.AdminId like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+AdminId+"%");
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
	public void delete_gly(String AdminId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		String sql="delete from gly where gly.AdminId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, AdminId);
		ps.executeUpdate();
		conn.commit();
		}catch(Exception e) {
			conn.rollback();
			e.printStackTrace();
		}finally {
				ps.close();
				conn.close();
		}

	}

	@Override
	public void update_gly(Gly gly) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update gly set gly.AdminName=? where gly.AdminId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, gly.getAdminName());
		ps.setString(2, gly.getAdminId());
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
