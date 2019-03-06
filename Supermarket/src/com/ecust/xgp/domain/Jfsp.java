package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jfsp database table.
 * 
 */
@Entity
@NamedQuery(name="Jfsp.findAll", query="SELECT j FROM Jfsp j")
public class Jfsp implements Serializable {
	private static final long serialVersionUID = 1L;

	private String itemId;

	private int neededIntegral;

	public Jfsp() {
	}
	
	public Jfsp(String itemId, int neededIntegral) {
		super();
		this.itemId = itemId;
		this.neededIntegral = neededIntegral;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getNeededIntegral() {
		return this.neededIntegral;
	}

	public void setNeededIntegral(int neededIntegral) {
		this.neededIntegral = neededIntegral;
	}

}