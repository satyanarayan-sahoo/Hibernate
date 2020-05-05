package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGER_BACKUP_HQL_COPY")
public class ManagerBackup {
	@Id
	@Column(name = "MBID")
	private int managerIdBkp;
	
	@Column(name = "MBNAME")
	private String managerNameBkp;
	
	@Column(name = "MBSALARY")
	private int managerSalaryBkp;

	public int getManagerIdBkp() {
		return managerIdBkp;
	}

	public void setManagerIdBkp(int managerIdBkp) {
		this.managerIdBkp = managerIdBkp;
	}

	public String getManagerNameBkp() {
		return managerNameBkp;
	}

	public void setManagerNameBkp(String managerNameBkp) {
		this.managerNameBkp = managerNameBkp;
	}

	public int getManagerSalaryBkp() {
		return managerSalaryBkp;
	}

	public void setManagerSalaryBkp(int managerSalaryBkp) {
		this.managerSalaryBkp = managerSalaryBkp;
	}

	@Override
	public String toString() {
		return "ManagerBackup [managerIdBkp=" + managerIdBkp + ", managerNameBkp=" + managerNameBkp
				+ ", managerSalaryBkp=" + managerSalaryBkp + "]";
	}
	
	
}//class
