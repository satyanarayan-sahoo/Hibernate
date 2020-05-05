package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLOYEE_SECONDARY_TAB")
@SecondaryTables({@SecondaryTable(name = "EMPLOYEE_SECONDARY_DETAILS"),@SecondaryTable(name = "EMPLOYEE_SECONDARY_ADDRESS",pkJoinColumns = @PrimaryKeyJoinColumn(name="EID"))})
public class Employee {
	@Id
	@Column(name = "EMPLOYEE_ID")
	private int empId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL_ID",table = "EMPLOYEE_SECONDARY_DETAILS")
	private String email;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "JOIN_DATE",table = "EMPLOYEE_SECONDARY_DETAILS")
	private Date joiningDate;
	
	@Column(name = "SALARY",table = "EMPLOYEE_SECONDARY_DETAILS")
	private int salary;
	
	@Column(name = "ADDRESS",table = "EMPLOYEE_SECONDARY_ADDRESS")
	private String address;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", joiningDate=" + joiningDate + ", salary=" + salary + ", address=" + address + "]";
	}
	
	
}//class
