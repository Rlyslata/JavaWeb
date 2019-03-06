package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Jfsp_dao;
import com.ecust.xgp.domain.Jfsp;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;

public class Jfsp_dao_impl implements Jfsp_dao {

	@Override
	public void insert_jfsp(Jfsp jfsp) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into Jfsp(ItemId,NeededIntegral) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, jfsp.getItemId());
			ps.setInt(2, jfsp.getNeededIntegral());
			
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
	public List<Map<String, Object>> findAll_jfsp(String ItemId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from jfsp where jfsp.ItemId like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+ItemId+"%");
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
	public void delete_jfsp(String ItemId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		String sql="delete from jfsp where jfsp.ItemId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, ItemId);
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

	@Override
	public void update_jfsp(Jfsp jfsp) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update jfsp set jfsp.NeededIntegral=? where jfsp.ItemId=? ";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, jfsp.getNeededIntegral());
		ps.setString(2, jfsp.getItemId());
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
