package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ygrz database table.
 * 
 */
@Entity
@NamedQuery(name="Ygrz.findAll", query="SELECT y FROM Ygrz y")
public class Ygrz implements Serializable {
	private static final long serialVersionUID = 1L;

	private String employeeId;

	private String roleId;

	public Ygrz() {
	}
	
	public Ygrz(String employeeId, String roleId) {
		super();
		this.employeeId = employeeId;
		this.roleId = roleId;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}