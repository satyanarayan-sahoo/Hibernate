package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "EMPLOYEE_BAG_TAB")
public class Employee {
	@Id
	@Column(name = "EID")
	private int empId;
	
	@Column(name = "ENAME")
	private String empName;
	
	@Column(name = "ESAL")
	private int empSal;
	
	@ElementCollection
	@CollectionTable(name = "EMPPROJ_BAG_TAB",joinColumns = @JoinColumn(name="EID"))
	@Column(name = "DATA")
	private List<String> empProj=new ArrayList<String>();

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

	public int getEmpSal() {
		return empSal;
	}

	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}

	public List<String> getEmpProj() {
		return empProj;
	}

	public void setEmpProj(List<String> empProj) {
		this.empProj = empProj;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empProj=" + empProj
				+ "]";
	}
	
}//class
