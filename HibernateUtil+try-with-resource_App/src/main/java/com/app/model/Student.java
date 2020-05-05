package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_UTIL_TAB")
public class Student {
	@Id
	@Column(name = "SID")
	private int stdId;
	
	@Column(name = "SNAME")
	private String stdName;
	
	@Column(name = "SFEE")
	private double stdFee;
	
	@Column(name = "SAGE")
	private int stdAge;

	public Student() {
		super();
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

	public double getStdFee() {
		return stdFee;
	}

	public void setStdFee(double stdFee) {
		this.stdFee = stdFee;
	}

	public int getStdAge() {
		return stdAge;
	}

	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}

	@Override
	public String toString() {
		return "Student[stdId="+stdId+",stdName="+stdName+",stdFee="+stdFee+",stdAge="+stdAge+"]";
	}
	
	
	
}//class
