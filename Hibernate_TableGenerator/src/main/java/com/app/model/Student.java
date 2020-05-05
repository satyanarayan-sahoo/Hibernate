package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "STUDENT_TABLE_GENERATOR")
public class Student {
	@Id
	@Column(name = "ID")
	
	/* In this way we are creating a new table and using that table for primary key */
	@GeneratedValue(generator = "table-generator")
    @TableGenerator(name = "table-generator",table = "TAB_GEN",pkColumnName = "PK_ID",valueColumnName = "SEQ_VALUE")
	
	/* In this way Hibernate by default create another table and using that table for primary key.
	@GeneratedValue(strategy = GenerationType.TABLE) */
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
