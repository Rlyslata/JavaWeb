package com.ecust.xgp.domain;

public class Role {
	int roleid;
	String rolename;
	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + "]";
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Role(int roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
