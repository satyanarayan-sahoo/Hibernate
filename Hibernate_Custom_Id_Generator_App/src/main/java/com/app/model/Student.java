package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STUDENT_CUSTOM_GENERATOR_TAB")
public class Student {
	@Id
	@Column(name = "SID")
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc",strategy = "com.app.gen.MyGenerator")
	private String stdId;
	
	@Column(name = "SNAME")
	private String stdName;
	
	@Column(name = "SFEE")
	private double stdFee;
	
	@Column(name = "SAGE")
	private int stdAge;

	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
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
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdFee=" + stdFee + ", stdAge=" + stdAge + "]";
	}
	
	
}//class
