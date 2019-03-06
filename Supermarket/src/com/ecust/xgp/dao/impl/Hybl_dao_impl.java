package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Hybl_dao;
import com.ecust.xgp.domain.Hybl;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;

public class Hybl_dao_impl implements Hybl_dao {

	@Override
	public void insert_hybl(Hybl hybl) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into hybl(MemberId,EmployeeId) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, hybl.getMemberId());
			ps.setString(2, hybl.getEmployeeId());
			
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
	public List<Map<String, Object>> findAll_hybl(String MemberId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from hybl where hybl.MenberId like ? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+MemberId+"%");
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
	public void delete_hybl(String MemberId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		String sql="delete from hybl where hybl.MemberId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, MemberId);
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
	public void update_hybl(Hybl hybl) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update hybl set hybl.EmployeeId=? where hybl.MemberId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, hybl.getEmployeeId());
		ps.setString(2, hybl.getMemberId());
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
