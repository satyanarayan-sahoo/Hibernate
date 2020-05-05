package com.app.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_COMPONENT_TAB")
public class Student {
	@Id
	@Column(name = "STUDENT_ID")
	private int stdId;
	
	@Column(name = "STUDENT_NAME")
	private String stdName;
	
	@Column(name = "STUDENT_EMAIL")
	private String emailId;
	
	@Column(name = "STUDENT_MOB")
	private String mobNo;
	
	@Embedded
	private Address addrs;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public Address getAddrs() {
		return addrs;
	}

	public void setAddrs(Address addrs) {
		this.addrs = addrs;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", emailId=" + emailId + ", mobNo=" + mobNo + "]";
	}
	
	
}//class
