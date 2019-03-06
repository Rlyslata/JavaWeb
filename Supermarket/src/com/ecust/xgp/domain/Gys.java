package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gys database table.
 * 
 */
@Entity
@NamedQuery(name="Gys.findAll", query="SELECT g FROM Gys g")
public class Gys implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;

	private String providerId;

	private String providerName;

	private String providerTelephone;

	public Gys() {
	}
	
	public Gys( String providerId, String providerName, String providerTelephone,String address) {
		super();
		this.address = address;
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerTelephone = providerTelephone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProviderId() {
		return this.providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return this.providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderTelephone() {
		return this.providerTelephone;
	}

	public void setProviderTelephone(String providerTelephone) {
		this.providerTelephone = providerTelephone;
	}

}