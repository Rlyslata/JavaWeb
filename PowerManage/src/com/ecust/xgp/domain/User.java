package com.ecust.xgp.domain;

public class User {
	private int  userid;
	private String username;
	private String password;
	private String qq;
	private String wechat;
	private String identitycard;
	private String telephone;
	private String address;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getIdentitycard() {
		return identitycard;
	}
	public void setIdentitycard(String identitycard) {
		this.identitycard = identitycard;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userid, String username, String password, String qq, String wechat, String identitycard,
			String telephone,String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.qq = qq;
		this.wechat = wechat;
		this.identitycard = identitycard;
		this.telephone=telephone;
		this.address = address;
	}
	public User( String username, String password, String qq, String wechat, String identitycard,
			String telephone,String address) {
		super();
		this.username = username;
		this.password = password;
		this.qq = qq;
		this.wechat = wechat;
		this.identitycard = identitycard;
		this.telephone=telephone;
		this.address = address;
	}
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", qq=" + qq
				+ ", wechat=" + wechat + ", identitycard=" + identitycard + ", address=" + address + "]";
	}
	
}
