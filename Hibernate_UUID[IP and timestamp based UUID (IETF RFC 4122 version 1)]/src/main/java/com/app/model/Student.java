package com.app.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



/* Hibernate can also generate a UUID based on IETF RFC 4122 version 1. If you follow the specification, you should generate the UUID with the MAC address
   instead of the IP address. As long as nobody is messing around with it, the MAC address of each device should be unique and due to this help to create a
   unique UUID. 
 * Hibernate uses the IP address instead of the MAC address. In general, this is not an issue. But if the servers of your distributed system are running in
   different networks you should make sure that none of them share the same IP address.
 * The configuration of the IETF RFC 4122 version 1 based UUID generator is similar to the previous one but requires an additional parameter that defines 
   the generation strategy. You can see an example of it in the following code snippet. You just need to provide an additional @Parameter annotation with the
   name uuid_gen_strategy_class and the fully qualified classname of the generation strategy as the value.*/

@Entity
@Table(name = "STUDENT_UUID_VERSION1_TAB")
public class Student {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID",strategy ="org.hibernate.id.UUIDGenerator",parameters = {@Parameter(name="uuid_gen_strategy_class",value = "org.hibernate.id.uuid.CustomVersionOneStrategy")})
	@Column(name = "SID")
	private UUID stdId;
	
	@Column(name = "SNAME")
	private String stdName;
	
	@Column(name = "SFEE")
	private double stdFee;
	
	@Column(name = "SAGE")
	private int stdAge;

	public Student() {
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
