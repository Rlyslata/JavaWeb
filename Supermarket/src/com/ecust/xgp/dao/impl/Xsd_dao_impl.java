package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Xsd_dao;
import com.ecust.xgp.domain.Xsd;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;
import com.ecust.xgp.utils.ToSqlDate;

public class Xsd_dao_impl implements Xsd_dao {

	@Override
	public void insert_xsd(Xsd xsd) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into xsd(SaleId,EmployeeId,CustomerNo,SaleDate) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, xsd.getSaleld());
			ps.setString(2,xsd.getEmployeeId());
			ps.setString(3, xsd.getCustomNo());
			ps.setDate(4, ToSqlDate.UtilDate_To_SqlDate(xsd.getSaleDate()));
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
	public List<Map<String, Object>> findAll_xsd(String Id) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from xsd where xsd.saleId like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+Id+"%");
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
	public void delete_xsd(String Id) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="delete from xsd where xsd.saleId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, Id);
		ps.executeUpdate();
		
		conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.rollback();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update_Xsd(Xsd xsd) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql=" update xsd set xsd.EmployeeId=?,xsd.CustomerNo=?,xsd.SaleDate=? where xsd.SaleIdId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, xsd.getEmployeeId());
		ps.setString(2, xsd.getCustomNo());
		ps.setDate(3, ToSqlDate.UtilDate_To_SqlDate(xsd.getSaleDate()));
		ps.setString(4, xsd.getSaleld());
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
	public void insert_xsd(Xsd xsd, Connection conn) throws Exception {
		PreparedStatement ps=null;
		try {
			String sql="insert into xsd(SaleId,EmployeeId,CustomerNo,SaleDate) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, xsd.getSaleld());
			ps.setString(2,xsd.getEmployeeId());
			ps.setString(3, xsd.getCustomNo());
			ps.setDate(4, ToSqlDate.UtilDate_To_SqlDate(xsd.getSaleDate()));
			ps.executeUpdate();
		}catch(Exception e) {
			throw new RuntimeException();
		}finally {
			ps.close();
		}		
	}
		
	}
