package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cgd database table.
 * 
 */
@Entity
@NamedQuery(name="Cgd.findAll", query="SELECT c FROM Cgd c")
public class Cgd implements Serializable {
	private static final long serialVersionUID = 1L;

	private String employeeId;

	private String providerId;

	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	@Id
	private String purchaseId;

	public Cgd() {
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getProviderId() {
		return this.providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

}