package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hybl database table.
 * 
 */
@Entity
@NamedQuery(name="Hybl.findAll", query="SELECT h FROM Hybl h")
public class Hybl implements Serializable {
	private static final long serialVersionUID = 1L;

	private String employeeId;

	private String memberId;

	public Hybl() {
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}