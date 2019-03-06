package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Hy_dao;
import com.ecust.xgp.domain.Hy;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;
import com.ecust.xgp.utils.ToSqlDate;

public class Hy_dao_impl implements Hy_dao {

	@Override
	public void insert_hy(Hy hy) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into hy(memberid,membername,handledate,enddate,memberlevel,ownintegral,	totalconsumemoney,telephone	) values(?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,hy.getMemberId());
			ps.setString(2, hy.getMemberName());
			ps.setDate(3, ToSqlDate.UtilDate_To_SqlDate(hy.getHandleDate()));
			ps.setDate(4, ToSqlDate.UtilDate_To_SqlDate(hy.getEndDate()));
			ps.setInt(5, hy.getMemeberLevel());
			ps.setInt(6,hy.getOwnIntegral());
			ps.setFloat(7,hy.getTotalconsumeMoney());
		    ps.setString(8, hy.getTelephone());
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
	public List<Map<String, Object>> findAll_hy(String memberid) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from hy where hy.memberid like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+memberid+"%");
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
	public void delete_hy(String memberid) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		String sql="delete from hy where hy.memberid=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, memberid);
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
	public void update_hy(Hy hy) throws Exception {   
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update hy set hy.membername=?,hy.handledate=?,hy.enddate=?,hy.memberlevel=?,hy.ownintegral=?,hy.totalconsumenumber=?,hy.telephone=? where hy.memberId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, hy.getMemberName());
		ps.setDate(2, ToSqlDate.UtilDate_To_SqlDate(hy.getHandleDate()));
		ps.setDate(3, ToSqlDate.UtilDate_To_SqlDate(hy.getEndDate()));
		ps.setInt(4, hy.getMemeberLevel());
		ps.setInt(5,hy.getOwnIntegral());
		ps.setFloat(6,hy.getTotalconsumeMoney());
	    ps.setString(7, hy.getTelephone());
	    ps.setString(8,hy.getMemberId());
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
	public void insert_hy(Hy hy, Connection conn) throws Exception {
		PreparedStatement ps=null;
		
		try {
			String sql="insert into hy(memberid,membername,handledate,enddate,memberlevel,ownintegral,	totalconsumemoney,telephone	) values(?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,hy.getMemberId());
			ps.setString(2, hy.getMemberName());
			ps.setDate(3, ToSqlDate.UtilDate_To_SqlDate(hy.getHandleDate()));
			ps.setDate(4, ToSqlDate.UtilDate_To_SqlDate(hy.getEndDate()));
			ps.setInt(5, hy.getMemeberLevel());
			ps.setInt(6,hy.getOwnIntegral());
			ps.setFloat(7,hy.getTotalconsumeMoney());
		    ps.setString(8, hy.getTelephone());
			ps.executeUpdate();

		}catch(Exception e) {
			
			throw new RuntimeException();
		}finally {
			ps.close();
		}
		
	}

	@Override
	public void update_hy(Hy hy, Connection conn) throws Exception {
		PreparedStatement ps=null;
		try {
		String sql="update hy set hy.membername=?,hy.handledate=?,hy.enddate=?,hy.memberlevel=?,hy.ownintegral=?,hy.totalconsumenumber=?,hy.telephone=? where hy.memberId=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, hy.getMemberName());
		ps.setDate(2, ToSqlDate.UtilDate_To_SqlDate(hy.getHandleDate()));
		ps.setDate(3, ToSqlDate.UtilDate_To_SqlDate(hy.getEndDate()));
		ps.setInt(4, hy.getMemeberLevel());
		ps.setInt(5,hy.getOwnIntegral());
		ps.setFloat(6,hy.getTotalconsumeMoney());
	    ps.setString(7, hy.getTelephone());
	    ps.setString(8,hy.getMemberId());
		ps.executeUpdate();
		
		
		}catch(Exception e) {
			throw new RuntimeException();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	}


