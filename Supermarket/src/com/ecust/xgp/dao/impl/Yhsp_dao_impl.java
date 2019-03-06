package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Yhsp_dao;
import com.ecust.xgp.domain.Yhsp;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;
import com.ecust.xgp.utils.ToSqlDate;

public class Yhsp_dao_impl implements Yhsp_dao{

	@Override
	public void insert_yhsp(Yhsp yhsp) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into yhsp(yhsp.ItemId,yhsp.FullCourtDiscount,yhsp.OneLevelDiscount,yhsp.TwoLevelDiscount,yhsp.ThreeLevelDiscount,yhsp.BeginDate,yhsp.EndDate) values(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, yhsp.getItemId());
			ps.setFloat(2, yhsp.getFullCourtDiscount());
			ps.setFloat(3, yhsp.getOneLevelDiscount());
			ps.setFloat(4, yhsp.getTwoLevelDiscount());
			ps.setFloat(5, yhsp.getThreeLevelDiscount());
			ps.setDate(6, ToSqlDate.UtilDate_To_SqlDate(yhsp.getBeginDate()));
			ps.setDate(7, ToSqlDate.UtilDate_To_SqlDate(yhsp.getEndDate()));
			
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
	public List<Map<String, Object>> findAll_yhsp(String ItemId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from yhsp where yhsp.ItemId like ?  ";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+ItemId+"%");
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
	public void delete_yhsp(String ItemId) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		String sql="delete from yhsp where yhsp.ItemId=?  ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, ItemId);
		
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
	public void update_yhsp(Yhsp yhsp) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update yhsp set yhsp.FullCourtDiscount=?,yhsp.OneLevelDiscount=?,yhsp.TwoLevelDiscount=?,yhsp.ThreeLevelDiscount=?,yhsp.BeginDate=?,yhsp.EndDate=? where yhsp.ItemId=? ";
		ps = conn.prepareStatement(sql);
		ps.setFloat(1, yhsp.getFullCourtDiscount());
		ps.setFloat(2, yhsp.getOneLevelDiscount());
		ps.setFloat(3, yhsp.getTwoLevelDiscount());
		ps.setFloat(4, yhsp.getThreeLevelDiscount());
		ps.setDate(5, ToSqlDate.UtilDate_To_SqlDate(yhsp.getBeginDate()));
		ps.setDate(6, ToSqlDate.UtilDate_To_SqlDate(yhsp.getEndDate()));
		ps.setString(7, yhsp.getItemId());
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
