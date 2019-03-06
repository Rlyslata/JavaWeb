package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the yhsp database table.
 * 
 */
@Entity
@NamedQuery(name="Yhsp.findAll", query="SELECT y FROM Yhsp y")
public class Yhsp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date beginDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private float fullCourtDiscount;

	private String itemId;

	private float oneLevelDiscount;

	private float threeLevelDiscount;

	private float twoLevelDiscount;

	public Yhsp() {
	}
	
	public Yhsp(String itemId, float fullCourtDiscount,  float oneLevelDiscount,
			 float twoLevelDiscount,float threeLevelDiscount,Date beginDate, Date endDate) {
		super();
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.fullCourtDiscount = fullCourtDiscount;
		this.itemId = itemId;
		this.oneLevelDiscount = oneLevelDiscount;
		this.threeLevelDiscount = threeLevelDiscount;
		this.twoLevelDiscount = twoLevelDiscount;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getFullCourtDiscount() {
		return this.fullCourtDiscount;
	}

	public void setFullCourtDiscount(float fullCourtDiscount) {
		this.fullCourtDiscount = fullCourtDiscount;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public float getOneLevelDiscount() {
		return this.oneLevelDiscount;
	}

	public void setOneLevelDiscount(float oneLevelDiscount) {
		this.oneLevelDiscount = oneLevelDiscount;
	}

	public float getThreeLevelDiscount() {
		return this.threeLevelDiscount;
	}

	public void setThreeLevelDiscount(float threeLevelDiscount) {
		this.threeLevelDiscount = threeLevelDiscount;
	}

	public float getTwoLevelDiscount() {
		return this.twoLevelDiscount;
	}

	public void setTwoLevelDiscount(float twoLevelDiscount) {
		this.twoLevelDiscount = twoLevelDiscount;
	}

}