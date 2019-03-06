package com.ecust.xgp.dao;

import java.util.List;

import com.ecust.xgp.domain.User_Role;

public interface User_RoleDao {
	//用户权限表
	void addUser(int userid,String rolename) throws Exception;
	void deleteUser(int userid) throws Exception;
	List<User_Role> findByUsername(String username);
}
