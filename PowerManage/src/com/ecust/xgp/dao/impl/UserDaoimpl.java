package com.ecust.xgp.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.ecust.xgp.dao.UserDao;
import com.ecust.xgp.domain.User;

public class UserDaoimpl implements UserDao{
	public User findByusername(String username) {
		User user=null;
		Connection conn=JdbcUtils.getConnection();
		//必须先声明否则finally中无法关闭
		PreparedStatement ps=null;
		ResultSet resultSet=null;
		String sql="select* from user where username=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			resultSet = ps.executeQuery();
			if(resultSet.next())
			{
			user=new User();
			user.setUserid(resultSet.getInt("userid"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setQq(resultSet.getString("qq"));
			user.setWechat(resultSet.getString("wechat"));
			user.setIdentitycard(resultSet.getString("identitycard"));
			user.setTelephone(resultSet.getString("telephone"));
			user.setAddress(resultSet.getString("address"));
			/*
			 * .....user其他属性
			 */
			return user;
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			try {
			resultSet.close();
			ps.close();
			conn.close();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
			
		}
		return null;	
	}
	public Map<String,Object> findByuserid(int userid) {
		Connection conn=JdbcUtils.getConnection();
		//必须先声明否则finally中无法关闭
		PreparedStatement ps=null;
		ResultSet resultSet=null;
		Map<String,Object> map=null;
		String sql="select* from user where userid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			resultSet = ps.executeQuery();
			map=CovertUtils.CovertMap(resultSet);
			return map;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			try {
			ps.close();
			conn.close();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
			
		}
	}
	/*
	 * 在user表中添加记录
	 * @see com.ecust.xgp.dao.UserDao#addUser(com.ecust.xgp.domain.User)
	 */
	public void addUser(User user) {
		Connection conn=JdbcUtils.getConnection();
		//必须先声明否则finally中无法关闭
		PreparedStatement ps=null;
		try {
			String sql="insert into user (username,password,qq,wechat,identitycard,telephone,address) values(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, new String(user.getUsername().getBytes("UTF-8"),"UTF-8"));
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getQq());
			ps.setString(4, user.getWechat());
			ps.setString(5, user.getIdentitycard());
			ps.setString(6, user.getTelephone());
			ps.setString(7, user.getAddress());
			/*
			 * ....其他属性
			 */
			ps.executeUpdate();
		}catch (Exception e){	
			throw new RuntimeException(e);
		}finally {
			try {
			ps.close();
			conn.close();
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
	}
	
	@Override
	public void deleteUser(int userid) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn = JdbcUtils.getConnection();
			String sql="delete from user where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			try {
				ps.close();
				conn.close();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	public void updateUser(User user)throws Exception{
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="update user set username=?,password=?,qq=?,wechat=?,identitycard=?,telephone=?,address=?"+
			"  where userid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getQq());
			ps.setString(4, user.getWechat());
			ps.setString(5, user.getIdentitycard());
			ps.setString(6, user.getTelephone());
			ps.setString(7, user.getAddress());
			ps.setInt(8, user.getUserid());
			ps.execute();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			ps.close();
			conn.close();
		}
	}
	
}
