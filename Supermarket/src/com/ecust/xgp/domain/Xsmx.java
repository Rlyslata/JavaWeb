package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the xsmx database table.
 * 
 */
@Entity
@NamedQuery(name="Xsmx.findAll", query="SELECT x FROM Xsmx x")
public class Xsmx implements Serializable {
	private static final long serialVersionUID = 1L;

	private String itemId;

	private String saleId;

	private int saleIntegral;

	private int saleNum;

	private float salePrice;

	public Xsmx() {
	}
	
	public Xsmx( String saleId,String itemId,  int saleNum,int salePrice,int saleIntegral) {
		super();
		this.itemId = itemId;
		this.saleId = saleId;
		this.saleIntegral = saleIntegral;
		this.saleNum = saleNum;
		this.salePrice = salePrice;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getSaleId() {
		return this.saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public int getSaleIntegral() {
		return this.saleIntegral;
	}

	public void setSaleIntegral(int saleIntegral) {
		this.saleIntegral = saleIntegral;
	}

	public int getSaleNum() {
		return this.saleNum;
	}

	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}

	public float getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}

}