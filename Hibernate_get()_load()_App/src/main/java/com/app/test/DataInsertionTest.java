package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.model.Student;

public class DataInsertionTest {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Student s1=new Student();
		s1.setStdId(101);
		s1.setStdName("Raja");
		s1.setStdAge(23);
		s1.setStdFee(12345.67);
		ses.save(s1);
		
		Student s2=new Student();
		s2.setStdId(102);
		s2.setStdName("MaheshBabu");
		s2.setStdAge(45);
		s2.setStdFee(65789.12);
		ses.save(s2);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
