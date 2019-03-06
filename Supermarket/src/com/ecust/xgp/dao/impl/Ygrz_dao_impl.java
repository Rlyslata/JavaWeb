package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Ygrz_dao;
import com.ecust.xgp.domain.Ygrz;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;

public class Ygrz_dao_impl implements Ygrz_dao{

	@Override
	public void insert_ygrz(Ygrz ygrz) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into ygrz(EmployeeId,RoleId) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, ygrz.getEmployeeId());
			ps.setString(2, ygrz.getRoleId());
			
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
	public List<Map<String, Object>> findAll_ygrz(String EmployeeId, String RoleId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from ygrz where ygrz.EmployeeId like ? and ygrz.RoleId like ? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+EmployeeId+"%");
			ps.setString(2, "%"+RoleId+"%");
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
	public void delete_ygrz(String EmployeeId, String RoleId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		String sql="delete from ygrz where ygrz.EmployeeId=? and ygrz.RoleId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, EmployeeId);
		ps.setString(2, RoleId);
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
	public void update_ygrz(Ygrz ygrz) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update ygrz set ygrz.EmployeeId=?,ygrz.RoleId=? where ygrz.EmployeeId=? and ygrz.RoleId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, ygrz.getEmployeeId());
		ps.setString(2, ygrz.getRoleId());
		ps.setString(3, ygrz.getEmployeeId());
		ps.setString(4, ygrz.getRoleId());
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
