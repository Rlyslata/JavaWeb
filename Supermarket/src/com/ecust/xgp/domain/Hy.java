package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hy database table.
 * 
 */
@Entity
@NamedQuery(name="Hy.findAll", query="SELECT h FROM Hy h")
public class Hy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Temporal(TemporalType.DATE)
	private Date handleDate;
	@Id
	private String memberId;

	private String memberName;

	private int memberLevel;

	private int ownIntegral;

	private String telephone;

	private float totalconsumeMoney;

	public Hy() {
	}
	
	public Hy(String memberId, String memberName,Date handleDate, Date endDate,  int memeberLevel,
			int ownIntegral,float totalconsumeMoney, String telephone) {
		super();
		this.endDate = endDate;
		this.handleDate = handleDate;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberLevel = memeberLevel;
		this.ownIntegral = ownIntegral;
		this.telephone = telephone;
		this.totalconsumeMoney = totalconsumeMoney;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getHandleDate() {
		return this.handleDate;
	}

	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}

	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemeberLevel() {
		return this.memberLevel;
	}

	public void setMemeberLevel(int memeberLevel) {
		this.memberLevel = memeberLevel;
	}

	public int getOwnIntegral() {
		return this.ownIntegral;
	}

	public void setOwnIntegral(int ownIntegral) {
		this.ownIntegral = ownIntegral;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public float getTotalconsumeMoney() {
		return this.totalconsumeMoney;
	}

	public void setTotalconsumeMoney(float totalconsumeMoney) {
		this.totalconsumeMoney = totalconsumeMoney;
	}

}