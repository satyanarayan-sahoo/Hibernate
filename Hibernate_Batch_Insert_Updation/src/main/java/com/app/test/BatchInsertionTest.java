package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

public class BatchInsertionTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		try(Session ses=sf.openSession()){
			Transaction tx=ses.beginTransaction();
			
			/* This may cause OutOfMemoryError because Hibernate manages each instance of the Customer object in its session’s cache. */
			/*for (int i = 1; i <= 100; i++) {
				Student s=new Student(i,"Raja"+i,20+i);
				ses.save(s);
			}//for
			
			/* A solution is to flush and clear the session repeatedly after a number of objects persisted, like this: */
			for (int i = 1; i <= 100; i++) {
				Student s=new Student(i,"Raja"+i,20+i);
				ses.save(s);
				
				if (i%30==0) {
					//flush a batch of inserts through ses.flush(); method and release memory through ses.clear(); .
					ses.flush();
					ses.clear();
				}//if
				
			}//for
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
