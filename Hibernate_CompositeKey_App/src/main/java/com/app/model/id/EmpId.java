package com.app.model.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpId implements Serializable{
	
	@Column(name = "EID")
	private int empId;
	
	@Column(name = "ENAME")
	private String empName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "EmpId [empId=" + empId + ", empName=" + empName + "]";
	}
	
	
}//class
