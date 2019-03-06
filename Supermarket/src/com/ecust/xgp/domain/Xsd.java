package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the xsd database table.
 * 
 */
@Entity
@NamedQuery(name="Xsd.findAll", query="SELECT x FROM Xsd x")
public class Xsd implements Serializable {
	private static final long serialVersionUID = 1L;

	private String customNo;

	private String employeeId;

	@Temporal(TemporalType.DATE)
	private Date saleDate;

	private String saleld;

	public Xsd() {
	}
	
	public Xsd(String customNo, String employeeId, Date saleDate, String saleld) {
		super();
		this.customNo = customNo;
		this.employeeId = employeeId;
		this.saleDate = saleDate;
		this.saleld = saleld;
	}

	public String getCustomNo() {
		return this.customNo;
	}

	public void setCustomNo(String customNo) {
		this.customNo = customNo;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public String getSaleld() {
		return this.saleld;
	}

	public void setSaleld(String saleld) {
		this.saleld = saleld;
	}

}