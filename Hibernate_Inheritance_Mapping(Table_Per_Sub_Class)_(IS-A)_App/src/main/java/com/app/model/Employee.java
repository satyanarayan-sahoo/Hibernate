package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_TAB_PER_SUB_CLASS")
@PrimaryKeyJoinColumn(name = "EMPLOYEE_ID")
public class Employee extends Person {
	@Column(name = "SALARY")
	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + "]";
	}
	
	
}//class
