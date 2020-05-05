package com.app.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "STD")
public class Student extends Person {
	@Column(name = "FEE")
	private int fee;
	
	@Column(name = "COURSE")
	private String course;

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [fee=" + fee + ", course=" + course + "]";
	}
	
	
}//class
