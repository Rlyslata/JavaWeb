package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Cgd_dao;
import com.ecust.xgp.domain.Cgd;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;
import com.ecust.xgp.utils.ToSqlDate;

public class Cgd_dao_impl implements Cgd_dao {

	@Override
	public void insert_cgd(Cgd cgd) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into cgd(PurchaseId,EmployeeId,ProviderId,PurchaseDate) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, cgd.getProviderId());
			ps.setString(2, cgd.getEmployeeId());
			ps.setString(3, cgd.getProviderId());
			ps.setDate(4, ToSqlDate.UtilDate_To_SqlDate(cgd.getPurchaseDate()));
			
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
	public List<Map<String, Object>> findAll_cgd(String PurchaseId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from cgd where cgd.PurchaseId like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+PurchaseId+"%");
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
	public void delete_cgd(String PurchaseId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		String sql="delete from cgd where cgd.PurchaseId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, PurchaseId);
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
	public void update_cgd(Cgd cgd) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update cgd set cgd.EmployeeId=?,cgd.ProviderId=?,cgd.PurchaseDate=? where cgd.PurchaseId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, cgd.getEmployeeId());
		ps.setString(2, cgd.getProviderId());
		ps.setDate(3, ToSqlDate.UtilDate_To_SqlDate(cgd.getPurchaseDate()));
		ps.setString(4, cgd.getPurchaseId());
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
	public void insert_cgd(Cgd cgd, Connection conn) throws Exception {
		PreparedStatement ps=null;
		
		try {
			
			String sql="insert into cgd(PurchaseId,EmployeeId,ProviderId,PurchaseDate) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, cgd.getProviderId());
			ps.setString(2, cgd.getEmployeeId());
			ps.setString(3, cgd.getProviderId());
			ps.setDate(4, ToSqlDate.UtilDate_To_SqlDate(cgd.getPurchaseDate()));
			
			ps.executeUpdate();
			
		}catch(Exception e) {
			
			throw new RuntimeException();
		}finally {
			ps.close();
		}

	}

}
