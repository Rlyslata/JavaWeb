package com.ecust.xgp.domain;

public class User_Role {
	int userid;
	int roleid;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public User_Role(int userid, int roleid) {
		super();
		this.userid = userid;
		this.roleid = roleid;
	}
	public User_Role() {
		super();
		// TODO Auto-generated constructor stub
	}
}
