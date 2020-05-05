package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/* We just provide strategy = "increment" in side @GenericGenerator */

@Entity
@Table(name = "STUDENT_INCREMENT_TAB")
public class Student {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator ="increment-generator" )
	@GenericGenerator(name = "increment-generator",strategy = "increment")
	private long sid;
	@Column(name = "NAME")
	private String sname;
	@Column(name = "AGE")
	private int age;
	public Student() {
		super();
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", age=" + age + "]";
	}
	
}//class
