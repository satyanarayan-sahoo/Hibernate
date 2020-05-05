package com.app.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.id.EmpId;

@Entity
@Table(name = "EMPLOYEE_COMPOSITEKEY_TAB")
public class Employee {
	@EmbeddedId
	private EmpId eidPk;
	
	@Column(name = "EMP_SAL")
	private int empSal;

	public EmpId getEidPk() {
		return eidPk;
	}

	public void setEidPk(EmpId eidPk) {
		this.eidPk = eidPk;
	}

	public int getEmpSal() {
		return empSal;
	}

	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}

	@Override
	public String toString() {
		return "Employee [eidPk=" + eidPk + ", empSal=" + empSal + "]";
	}
	
	
}//class
