package com.app.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_SET_MAP_TAB")
public class Employee {
	
	@Id
	@Column(name = "EID")
	private int empId;
	
	@Column(name = "ENAME")
	private String empName;
	
	@ElementCollection
	@CollectionTable(name = "EMPDATA_SET_TAB",joinColumns = @JoinColumn(name="EID"))
	@Column(name = "DATA")
	private Set<String> empData=new HashSet<String>(); 
	
	@ElementCollection
	@CollectionTable(name = "EMPADDRESS_MAP_TAB",joinColumns = @JoinColumn(name="EID"))
	@MapKeyColumn(name = "ADDNO")
	@Column(name = "ADDRESS")
	private Map<Integer, String> empAddrs=new HashMap<Integer, String>();
	
	public Employee() {
		super();
	}

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

	public Set<String> getEmpData() {
		return empData;
	}

	public void setEmpData(Set<String> empData) {
		this.empData = empData;
	}

	public Map<Integer, String> getEmpAddrs() {
		return empAddrs;
	}

	public void setEmpAddrs(Map<Integer, String> empAddrs) {
		this.empAddrs = empAddrs;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empData=" + empData + ", empAddrs=" + empAddrs
				+ "]";
	}
	
}//class
