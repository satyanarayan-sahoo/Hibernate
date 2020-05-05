package com.app.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Address;
import com.app.model.Student;
import com.app.util.HibernateUtil;

public class ComponentMappingTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Address addrs1=new Address();
		addrs1.setHouseNo("H-122");
		addrs1.setPinCode("759017");
		addrs1.setCity("Bhuban");
		addrs1.setState("Odisha");
		
		
		Student s1=new Student();
		s1.setStdId(1111);
		s1.setStdName("Raja");
		s1.setEmailId("rajaji4444@gmail.com");
		s1.setMobNo("9437514517");
		s1.setAddrs(addrs1);
		
		ses.save(s1);
		
		Address addrs2=new Address();
		addrs2.setHouseNo("P-132");
		addrs2.setPinCode("560037");
		addrs2.setCity("Marathahalli");
		addrs2.setState("Karnataka");
		
		Student s2=new Student();
		s2.setStdId(2222);
		s2.setStdName("Jahar");
		s2.setEmailId("jaharjagdev@gmail.com");
		s2.setMobNo("7634971257");
		s2.setAddrs(addrs2);
		
		ses.save(s2);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
