package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Gn_dao;
import com.ecust.xgp.domain.Gn;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;

public class Gn_dao_impl implements Gn_dao {

	@Override
	public void insert_gn(Gn gn) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into gn(OperationId,OperationName) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, gn.getOperationId());
			ps.setString(2, gn.getOperationName());
			
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
	public List<Map<String, Object>> findAll_gn(String OperationId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from gn where gn.OperationId like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+OperationId+"%");
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
	public void delete_gn(String OperationId) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		String sql="delete from gn where gn.OperationId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, OperationId);
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
	public void update_gn(Gn gn) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update gn set gn.OperationName=? where gn.OperationId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, gn.getOperationName());
		ps.setString(2, gn.getOperationId());
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
