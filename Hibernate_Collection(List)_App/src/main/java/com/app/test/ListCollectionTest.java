package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

public class ListCollectionTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Student std=new Student();
		std.setStdId(101);
		std.setStdName("RAJ");
		std.getStdProjData().add("P1");
		std.getStdProjData().add("P2");
		std.getStdProjData().add("P3");
		ses.save(std);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
