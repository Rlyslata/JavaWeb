package com.ecust.xgp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecust.xgp.dao.Yg_dao;
import com.ecust.xgp.domain.Yg;
import com.ecust.xgp.utils.CovertUtils;
import com.ecust.xgp.utils.JdbcUtils;
import com.ecust.xgp.utils.ToSqlDate;

public class Yg_dao_impl implements Yg_dao {

	@Override
	public void Insert_Yg(Yg yg) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		
		try {
			/*
			 * 关闭自动提交
			 */
			conn.setAutoCommit(false);
			String sql="insert into yg(EmployeeId,EmployeePassword,EmployeeName,AttendDate,Birth,Salary) values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, yg.getEmployeeId());
			ps.setString(2, yg.getEmployeePassword());
			ps.setString(3, yg.getEmployeeName());
			ps.setDate(4, new java.sql.Date(yg.getAttendDate().getTime()));
			ps.setDate(5, new java.sql.Date(yg.getBirth().getTime()));
			ps.setInt(6, yg.getSalary());
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
	public List<Map<String,Object>> findByYgAll(String Id) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet re=null;
		try {
			conn.setAutoCommit(false);
			
			String sql="select * from yg where yg.employeeId like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+Id+"%");
			re=ps.executeQuery();
			
			conn.commit();
			
			return CovertUtils.CovertList(re);
		}catch(Exception e) {
			conn.rollback();
			throw new RuntimeException();
		}finally {
			System.out.println(re);
			System.out.println(ps);
			System.out.println(conn);
			re.close();
			ps.close();
			conn.close();
		}
	}

	@Override
	public void delete_Yg(String Id) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		String sql="delete from yg where yg.employeeId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, Id);
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
	public void update_Yg(Yg yg) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement ps=null;
		try {
		conn.setAutoCommit(false);
		
		String sql="update yg set yg.EmployeePassword=?,yg.EmployeeName=?,yg.AttendDate=?,yg.Birth=?,yg.Salary=? where yg.EmployeeId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, yg.getEmployeePassword());
		ps.setString(2, yg.getEmployeeName());
		ps.setDate(3, ToSqlDate.UtilDate_To_SqlDate(yg.getAttendDate()));
		ps.setDate(4, ToSqlDate.UtilDate_To_SqlDate(yg.getBirth()));
		ps.setInt(5, yg.getSalary());
		ps.setString(6, yg.getEmployeeId());
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
