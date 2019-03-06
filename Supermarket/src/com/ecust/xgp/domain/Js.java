package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the js database table.
 * 
 */
@Entity
@NamedQuery(name="Js.findAll", query="SELECT j FROM Js j")
public class Js implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String roleId;

	private String roleName;

	public Js() {
	}
	
	public Js(String roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}