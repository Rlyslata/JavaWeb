package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gn database table.
 * 
 */
@Entity
@NamedQuery(name="Gn.findAll", query="SELECT g FROM Gn g")
public class Gn implements Serializable {
	private static final long serialVersionUID = 1L;

	private String operationId;

	private String operationName;

	public Gn() {
	}
	
	public Gn(String operationId, String operationName) {
		super();
		this.operationId = operationId;
		this.operationName = operationName;
	}

	public String getOperationId() {
		return this.operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getOperationName() {
		return this.operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

}