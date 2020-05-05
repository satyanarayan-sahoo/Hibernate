package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "EMPLOYEE_NAMED_QUERY_TAB")
@NamedQueries({@NamedQuery(name = Employee.GET_EMPLOYEE_BY_ID,query = Employee.GET_EMPLOYEE_BY_ID_QUERY),@NamedQuery(name = Employee.UPDATE_EMPLOYEE_BY_ID,query = Employee.UPDATE_EMPLOYEE_BY_IDD_QUERY)})
public class Employee {
	public static final String GET_EMPLOYEE_BY_ID = "GET_EMPLOYEE_BY_ID";
	static final String GET_EMPLOYEE_BY_ID_QUERY = "from Employee e where e.empId = :id";
	
	public static final String UPDATE_EMPLOYEE_BY_ID = "UPDATE_EMPLOYEE_BY_ID";
	static final String UPDATE_EMPLOYEE_BY_IDD_QUERY = "update Employee e set e.empName = :name,e.empSal =: sal where e.empId= :id";
	
	@Id
	@Column(name = "EID")
	private int empId;
	
	@Column(name = "ENAME")
	private String empName;
	
	@Column(name = "ESAL")
	private int empSal;

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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}
	
}//class
