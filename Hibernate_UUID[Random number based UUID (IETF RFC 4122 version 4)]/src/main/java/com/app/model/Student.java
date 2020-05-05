package com.app.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



/* By default, Hibernate uses a random number based generation strategy. As always, you don’t have to do much to get the default behaviour. 
   You just need to add a @GeneratedValue annotation that references the ID generator to your primary key attribute and define the generator
   with one of Hibernate’s @GenericGenerator annotations. The @GenericGenerator annotation requires 2 parameters, the name of the generator 
   and the name of the class that implements the generator. In this case, it’s the org.hibernate.id.UUIDGenerator.
 * That’s all you have to do to let Hibernate generate UUIDs as primary key values. */

@Entity
@Table(name = "STUDENT_UUID_VERSION4_TAB")
public class Student {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID",strategy ="org.hibernate.id.UUIDGenerator")
	@Column(name = "SID")
	private UUID stdId;
	
	@Column(name = "SNAME")
	private String stdName;
	
	@Column(name = "SFEE")
	private double stdFee;
	
	@Column(name = "SAGE")
	private int stdAge;

	public Student() {
		super();
	}

	public UUID getStdId() {
		return stdId;
	}

	public void setStdId(UUID stdId) {
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
