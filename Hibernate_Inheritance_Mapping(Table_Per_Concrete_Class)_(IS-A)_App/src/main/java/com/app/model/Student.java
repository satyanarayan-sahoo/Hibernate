package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_TAB_PER_CON_CLASS")
public class Student extends Person {
	@Column(name = "FEE")
	private int fee;
	
	@Column(name = "GRADE")
	private String grade;

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [fee=" + fee + ", grade=" + grade + "]";
	}
	
}//class
