package com.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS_BIDIRECTIONAL_MANY21")
public class Address {
	@Id
	@Column(name = "ADDRESS_ID")
	private int addrsId;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "ZIPCODE")
	private int zipCode;
	
	@OneToMany(mappedBy = "adrs",cascade = CascadeType.ALL)
	private List<Employee> employees;

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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Address [addrsId=" + addrsId + ", city=" + city + ", zipCode=" + zipCode + "]";
	}
	
}//class
