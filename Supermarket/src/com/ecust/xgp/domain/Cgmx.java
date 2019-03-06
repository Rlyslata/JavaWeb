package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cgmx database table.
 * 
 */
@Entity
@NamedQuery(name="Cgmx.findAll", query="SELECT c FROM Cgmx c")
public class Cgmx implements Serializable {
	private static final long serialVersionUID = 1L;

	private String itemId;

	private float price;

	private String purchaseId;

	private int quantity;

	public Cgmx() {
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}