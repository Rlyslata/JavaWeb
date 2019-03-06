package com.ecust.xgp.dao;


import java.util.Map;

import com.ecust.xgp.domain.User;

public interface UserDao {
	User findByusername(String username);
	Map<String,Object> findByuserid(int userid) ;
	void addUser(User user);
//	List<User> findAll(int begin,int end);
	void deleteUser(int userid);
	void updateUser(User user)throws Exception;
}
