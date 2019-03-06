package com.ecust.xgp.dao;

import com.ecust.xgp.domain.Role;

public interface RoleDao {
	Role findByrolename(String rolename);
}
