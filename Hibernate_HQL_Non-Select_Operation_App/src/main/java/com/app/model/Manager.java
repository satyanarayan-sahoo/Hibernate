package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGER_HQL_NONSELECT")
public class Manager {
	@Id
	@Column(name = "MID")
	private int managerId;
	
	@Column(name = "MNAME")
	private String managerName;
	
	@Column(name = "MSALARY")
	private int managerSalary;
	
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getManagerSalary() {
		return managerSalary;
	}
	public void setManagerSalary(int managerSalary) {
		this.managerSalary = managerSalary;
	}
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", managerSalary=" + managerSalary
				+ "]";
	}
	
	
}//class
