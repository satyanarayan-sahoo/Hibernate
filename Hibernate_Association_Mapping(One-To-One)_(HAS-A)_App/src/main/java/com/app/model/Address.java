package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS121_TAB")
public class Address {
	@Id
	@Column(name = "ADDRESS_ID")
	private int addrsId;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "ZIPCODE")
	private int zipCode;

	public int getAddrsId() {
		return addrsId;
	}

	public void setAddrsId(int addrsId) {
		this.addrsId = addrsId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [addrsId=" + addrsId + ", city=" + city + ", zipCode=" + zipCode + "]";
	}
	
	
}//class
