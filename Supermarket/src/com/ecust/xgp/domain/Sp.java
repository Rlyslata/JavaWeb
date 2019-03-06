package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the sp database table.
 * 
 */
@Entity
@NamedQuery(name="Sp.findAll", query="SELECT s FROM Sp s")
public class Sp implements Serializable {
	private static final long serialVersionUID = 1L;

	private int inventory;

	private String itemId;

	private String itemName;

	private float itemPrice;

	private String itemSize;

	private String provider;

	public Sp() {
	}

	public Sp( String itemId, String itemName, String itemSize,float itemPrice,  String provider,int inventory) {
		super();
		this.inventory = inventory;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemSize = itemSize;
		this.provider = provider;
	}

	public int getInventory() {
		return this.inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemSize() {
		return this.itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

}