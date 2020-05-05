package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue(value = "EMP")
public class Employee extends Person {
	
	@Column(name = "JOIN_DATE")
	@Temporal(value = TemporalType.DATE)
	private Date joiningDate;
	
	@Column(name = "DEPT_NAME")
	private String departmentName;

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Employee [joiningDate=" + joiningDate + ", departmentName=" + departmentName + "]";
	}
	
	
}//class
