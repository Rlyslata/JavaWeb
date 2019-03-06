package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Xsmx_dao;
import com.ecust.xgp.domain.Xsmx;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;

public class Xsmx_dao_impl implements Xsmx_dao {

	@Override
	public void insert_xsmx(Xsmx xsmx) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql=" insert into Xsmx(SaleId,ItemId,SaleNum,SalePrice,SaleIntergral) values(?,?,?,?,?) ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, xsmx.getSaleId());
			ps.setString(2, xsmx.getItemId());
			ps.setInt(3, xsmx.getSaleNum());
			ps.setFloat(4, xsmx.getSalePrice());
			ps.setInt(5, xsmx.getSaleIntegral());
			
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
	public List<Map<String, Object>> findAll_xsmx(String SaleId, String ItemId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from Xsmx where Xsmx.SaleId like ? and Xsmx.ItemId like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+SaleId+"%");
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
	public void delete_xsmx(String SaleId,String ItemId) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		String sql=" delete from Xsmx where Xsmx.SaleId=? and Xsmx.ItemId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, SaleId);
		ps.setString(2, ItemId);
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
	public void update_xsmx(Xsmx xsmx) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update xsmx set xsmx.SaleNum=?,xsmx.SalePrice=?,xsmx.SaleIntergral=? where xsmx.SaleId=? and xsmx.ItemId=? ";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, xsmx.getSaleNum());;
		ps.setFloat(2, xsmx.getSalePrice());
		ps.setInt(3, xsmx.getSaleIntegral());
		ps.setString(4, xsmx.getSaleId());
		ps.setString(5, xsmx.getItemId());
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
	public void insert_xsmx(Xsmx xsmx, Connection conn) throws Exception {
		PreparedStatement ps=null;
		
		try {
			String sql=" insert into Xsmx(SaleId,ItemId,SaleNum,SalePrice,SaleIntergral) values(?,?,?,?,?) ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, xsmx.getSaleId());
			ps.setString(2, xsmx.getItemId());
			ps.setInt(3, xsmx.getSaleNum());
			ps.setFloat(4, xsmx.getSalePrice());
			ps.setInt(5, xsmx.getSaleIntegral());
			
			ps.executeUpdate();
		}catch(Exception e) {
			throw new RuntimeException();
		}finally {
			ps.close();
		}
		
	}

	}

