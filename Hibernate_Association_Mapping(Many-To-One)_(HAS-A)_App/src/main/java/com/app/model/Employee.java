package com.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEEMANY21_TAB")
public class Employee {
	@Id
	@Column(name = "EMP_ID")
	private int employeeId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SALARY")
	private int salary;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDID_FK")
	private Address adrs;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Address getAdrs() {
		return adrs;
	}

	public void setAdrs(Address adrs) {
		this.adrs = adrs;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", adrs=" + adrs + "]";
	}
	
	
}//class
