package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* persist() guarantees that it will not execute an insert statement if it is called outside of transaction boundaries */

public class PersistTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf(); 
		
		Session ses1=sf.openSession();
		Transaction tx1=ses1.beginTransaction();
		Student s1=new Student();
		s1.setStdId(701);
		s1.setStdName("Raja Babu");
		s1.setStdFee(12000.500);
		s1.setStdAge(23);
		ses1.persist(s1);
		tx1.commit();
		System.out.println("Successfully saved");
		ses1.close();
		
		Session ses2=sf.openSession();
		Student std=ses2.load(Student.class,701);
		std.setStdName("RRRBBB");
		ses2.persist(std);
		System.out.println("Successfully saved");
		ses2.close();
		
		sf.close();
	}//main

}//class
