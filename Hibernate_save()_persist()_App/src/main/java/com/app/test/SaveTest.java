package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* save() does not guarantees that it will not execute an insert statement if it is called outside of transaction boundaries.
   Because in save() method returns the identifier of that object */

public class SaveTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		
		Session ses1=sf.openSession();
		Student s1=new Student();
		s1.setStdId(702);
		s1.setStdName("Raja Babu");
		s1.setStdFee(12000.500);
		s1.setStdAge(23);
		int studentId1=(int) ses1.save(s1);
		System.out.println(" Identifier : " + studentId1);
		System.out.println(" Successfully saved");
		ses1.close();
		
		Session ses2=sf.openSession();
		Transaction tx=ses2.beginTransaction();
		Student s2=new Student();
		s2.setStdId(703);
		s2.setStdName("RRRR");
		s2.setStdFee(1234);
		s2.setStdAge(29);
		int studentId2=(int) ses2.save(s2);
		tx.commit();
		System.out.println(" Identifier : " + studentId2);
		System.out.println(" Successfully saved");
		ses2.close();
		
		sf.close();
	}//main

}//class
