package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jsgn database table.
 * 
 */
@Entity
@NamedQuery(name="Jsgn.findAll", query="SELECT j FROM Jsgn j")
public class Jsgn implements Serializable {
	private static final long serialVersionUID = 1L;

	private String operationId;

	private String roleId;

	public Jsgn() {
	}
	
	public Jsgn( String roleId,String operationId) {
		super();
		this.operationId = operationId;
		this.roleId = roleId;
	}

	public String getOperationId() {
		return this.operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}