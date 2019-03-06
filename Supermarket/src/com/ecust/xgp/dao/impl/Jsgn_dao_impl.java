package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Jsgn_dao;
import com.ecust.xgp.domain.Jsgn;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;

public class Jsgn_dao_impl implements Jsgn_dao {

	@Override
	public void insert_jsgn(Jsgn jsgn) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into jsgn(RoleId,OperationId) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, jsgn.getRoleId());
			ps.setString(2, jsgn.getOperationId());
			
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
	public List<Map<String, Object>> findAll_jsgn(String RoleId, String OperationId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from jsgn where jsgn.RoleId like ? and jsgn.OperationId like ? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+RoleId+"%");
			ps.setString(2, "%"+OperationId+"%");
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
	public void delete_jsgn(String RoleId, String OperationId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		String sql="delete from jsgn where jsgn.RoleId=? and jsgn.OperationId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, RoleId);
		ps.setString(2, OperationId);
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
	public void update_jsgn(Jsgn jsgn) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update jsgn set jsgn.RoleId=?,jsgn.OperationId=? where jsgn.RoleId=? and jsgn.OperationId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, jsgn.getRoleId());
		ps.setString(2, jsgn.getOperationId());
		ps.setString(3, jsgn.getRoleId());
		ps.setString(4, jsgn.getOperationId());
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
