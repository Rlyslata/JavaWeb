package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Gys_dao;
import com.ecust.xgp.domain.Gys;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;

public class Gys_dao_impl implements Gys_dao {

	@Override
	public void insert_gys(Gys gys) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into gys(ProviderId,ProviderName,ProviderTelephone,Address) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, gys.getProviderId());
			ps.setString(2, gys.getProviderName());
			ps.setString(3, gys.getProviderTelephone());
			ps.setString(4, gys.getAddress());
			
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
	public List<Map<String, Object>> findAll_gys(String ProviderId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from gys where gys.ProviderId like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+ProviderId+"%");
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
	public void delete_gys(String ProviderId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		String sql="delete from gys where gys.ProviderId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, ProviderId);
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
	public void update_gys(Gys gys) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update gys set gys.ProviderName=?,gys.ProviderTelephone=?,gys.Address=? where gys.ProviderId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, gys.getProviderName());
		ps.setString(2, gys.getProviderTelephone());
		ps.setString(3, gys.getAddress());
		ps.setString(4, gys.getProviderId());
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
