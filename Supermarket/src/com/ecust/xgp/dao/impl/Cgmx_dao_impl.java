package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Cgmx_dao;
import com.ecust.xgp.domain.Cgmx;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;

public class Cgmx_dao_impl implements Cgmx_dao {

	@Override
	public void insert_cgmx(Cgmx cgmx) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into cgmx(PurchaseId,ItemId,quantity,Price) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, cgmx.getPurchaseId());
			ps.setString(2, cgmx.getItemId());
			ps.setInt(3, cgmx.getQuantity());
			ps.setFloat(4, cgmx.getPrice());
			
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
	public List<Map<String, Object>> findAll_cgmx(String PurchaseId, String ItemId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from cgmx where cgmx.PurchaseId like ? and cgmx.ItemId like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+PurchaseId+"%");
			ps.setString(2, "%"+ItemId+"%");
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
	public void delete_cgmx(String PurchaseId, String ItemId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		String sql="delete from cgmx where cgmx.PurchaseId=? and cgmx.ItemId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, PurchaseId);
		ps.setString(2, ItemId);
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
	public void update_cgmx(Cgmx cgmx) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update cgmx set cgmx.Quantity=?,cgmx.Price=? where cgmx.PurchaseId=? and cgmx.ItemId=? ";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, cgmx.getQuantity());;
		ps.setFloat(2, cgmx.getPrice());
		ps.setString(3,cgmx.getPurchaseId());
		ps.setString(4, cgmx.getItemId());
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
	public void insert_cgmx(Cgmx cgmx, Connection conn) throws Exception {
PreparedStatement ps=null;
		
		try {
			 
			String sql="insert into cgmx(PurchaseId,ItemId,quantity,Price) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, cgmx.getPurchaseId());
			ps.setString(2, cgmx.getItemId());
			ps.setInt(3, cgmx.getQuantity());
			ps.setFloat(4, cgmx.getPrice());
			
			ps.executeUpdate();
			 
		}catch(Exception e) {
			 
			throw new RuntimeException();
		}finally {
			ps.close();
			 
		}

		
	}

}
