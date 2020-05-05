package com.app.test;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;


public class DataInsertionTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		try(Session ses=sf.openSession()){
			Transaction tx=ses.beginTransaction();
			
			Student s1=new Student();
			s1.setStdName("Papun");
			s1.setStdFee(8765.34);
			s1.setStdAge(23);
			ses.persist(s1);
			
			Student s2=new Student();
			s2.setStdName("Naresh");
			s2.setStdFee(7868.34);
			s2.setStdAge(24);
			ses.persist(s2);
			
			Student s3=new Student();
			s3.setStdName("Lipu");
			s3.setStdFee(1234.78);
			s3.setStdAge(24);
			UUID id=(UUID) ses.save(s3);
			System.out.println("The s3 Student sid is: "+id);
			
			Student s4=new Student();
			s4.setStdName("Vicky");
			s4.setStdFee(5678.78);
			s4.setStdAge(24);
			ses.saveOrUpdate(s4);
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
