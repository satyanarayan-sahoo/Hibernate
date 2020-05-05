package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.model.Student;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session ses=sf.openSession();
		
		Transaction tx=ses.beginTransaction();
		
		Student s=new Student();
		s.setStdId(101);
		s.setStdName("Raja");
		s.setStdFee(12000.500);
		s.setStdAge(23);
		Integer i1 = (Integer) ses.save(s);
		System.out.println(i1);
		
		Student s1=new Student();
		s1.setStdId(102);
		s1.setStdName("Rosy");
		s1.setStdFee(11345.500);
		s1.setStdAge(17);
		ses.saveOrUpdate(s1);
		
		Student s2=new Student();
		s2.setStdId(107);
		s2.setStdName("Naresh");
		s2.setStdFee(777.500);
		s2.setStdAge(24);
		ses.saveOrUpdate(s2);
		
		Student s3=new Student();
		s3.setStdId(111);
		s3.setStdName("Jaga");
		s3.setStdFee(888);
		s3.setStdAge(25);
		ses.persist(s3);
		
		Student s4=new Student();
		s4.setStdId(112);
		s4.setStdName("Babu");
		s4.setStdFee(888);
		s4.setStdAge(25);
		Integer i2 = (Integer) ses.save(s4);
		System.out.println(i2);
		
		ses.delete(s);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
