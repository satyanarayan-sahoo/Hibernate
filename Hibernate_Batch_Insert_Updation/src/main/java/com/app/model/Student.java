package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_BATCH_UPDATION")
public class Student {
	@Id
	@Column(name = "SID")
	private int stdId;
	
	@Column(name = "SNAME")
	private String stdName;
	
	@Column(name = "SAGE")
	private int stdAge;

	public Student() {
		super();
	}

	public Student(int stdId, String stdName, int stdAge) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdAge = stdAge;
	}



	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getStdAge() {
		return stdAge;
	}

	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdAge=" + stdAge + "]";
	}	
	
}//class
