package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Sp_dao;
import com.ecust.xgp.domain.Sp;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;

public class Sp_dao_impl implements Sp_dao {

	@Override
	public void insert_sp(Sp sp) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into sp(itemId,itemname,itemsize,itemprice,provider,inventory) values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, sp.getItemId());
			ps.setString(2, sp.getItemName());
			ps.setString(3, sp.getItemSize());
			ps.setFloat(4, sp.getItemPrice());
			ps.setString(5,sp.getProvider());
			ps.setInt(6,sp.getInventory());
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
	public List<Map<String, Object>> findAll_sp(String itemId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from sp where sp.itemId like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+itemId+"%");
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
	public void delete_sp(String itemId) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		String sql="delete from sp where sp.itemId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, itemId);
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
	public void update_sp(Sp sp) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update sp set sp.itemname=?,sp.itemsize=?,sp.itemprice=?,sp.provider=?,sp.inventory=? where cgd.itemId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, sp.getItemName());
		ps.setString(2, sp.getItemSize());
		ps.setFloat(3, sp.getItemPrice());
		ps.setString(4,sp.getProvider());
		ps.setInt(5,sp.getInventory());
		ps.setString(6, sp.getItemId());
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
	public List<Map<String, Object>> findSpByName(String itemName) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from sp where sp.itemName like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+itemName+"%");
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
	public void update_sp(Sp sp, Connection conn) throws Exception {
		PreparedStatement ps=null;
		try {
		String sql="update sp set sp.itemname=?,sp.itemsize=?,sp.itemprice=?,sp.provider=?,sp.inventory=? where cgd.itemId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, sp.getItemName());
		ps.setString(2, sp.getItemSize());
		ps.setFloat(3, sp.getItemPrice());
		ps.setString(4,sp.getProvider());
		ps.setInt(5,sp.getInventory());
		ps.setString(6, sp.getItemId());
		ps.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ps.close();
		}
	}

	@Override
	public void insert_sp(Sp sp, Connection conn) throws Exception {
		PreparedStatement ps=null;
		
		try {
			 
			String sql="insert into sp(itemId,itemname,itemsize,itemprice,provider,inventory) values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, sp.getItemId());
			ps.setString(2, sp.getItemName());
			ps.setString(3, sp.getItemSize());
			ps.setFloat(4, sp.getItemPrice());
			ps.setString(5,sp.getProvider());
			ps.setInt(6,sp.getInventory());
			ps.executeUpdate();
			 
		}catch(Exception e) {
			  
			throw new RuntimeException();
		}finally {
			ps.close();
		}

	}
	}


