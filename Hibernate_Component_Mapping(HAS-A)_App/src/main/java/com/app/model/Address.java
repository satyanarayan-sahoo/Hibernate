package com.app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "HOUSE_NO")
	private String houseNo;
	
	@Column(name = "PINCODE")
	private String pinCode;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", pinCode=" + pinCode + ", city=" + city + ", state=" + state + "]";
	}
	
	
}//class
