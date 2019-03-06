package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gly database table.
 * 
 */
@Entity
@NamedQuery(name="Gly.findAll", query="SELECT g FROM Gly g")
public class Gly implements Serializable {
	private static final long serialVersionUID = 1L;

	private String adminId;

	private String adminName;

	public Gly() {
	}
	
	public Gly(String adminId, String adminName) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
	}

	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

}