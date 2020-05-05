package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.model.Student;

/* Here the test class is designed through try-with-resource(AutoClosebale pattern).Means no need to close session object,it can be close automatically */

public class InsertionDataTest {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		try(Session ses=sf.openSession()){
			Transaction tx=ses.beginTransaction();
			
			Student s1=new Student();
			s1.setStdId(101);
			s1.setStdName("Raja");
			s1.setStdFee(7896.34);
			s1.setStdAge(24);
			ses.saveOrUpdate(s1);
			
			Student s2=new Student();
			s2.setStdId(102);
			s2.setStdName("Papun");
			s2.setStdFee(8765.34);
			s2.setStdAge(25);
			ses.saveOrUpdate(s2);
			
			Student s3=new Student();
			s3.setStdId(103);
			s3.setStdName("Lipu");
			s3.setStdFee(1111.34);
			s3.setStdAge(25);
			ses.saveOrUpdate(s3);
			
			Student s4=new Student();
			s4.setStdId(104);
			s4.setStdName("Vicky");
			s4.setStdFee(9898.34);
			s4.setStdAge(24);
			ses.saveOrUpdate(s4);
			
			tx.commit();
			sf.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
