package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

public class DataInsertionTest {

	public static void main(String[] args) {
		try(Session ses=HibernateUtil.getSf().openSession()) {
			Transaction tx=ses.beginTransaction();
			
			Student s1=new Student();
			s1.setSname("Raja");
			s1.setAge(23);
			long id=(long) ses.save(s1);
			System.out.println("The ID of s Object is:"+id);
			
			Student s2=new Student();
			s2.setSname("Lipu");
			s2.setAge(24);
			ses.persist(s2);
			
			Student s3=new Student();
			s3.setSname("Papun");
			s3.setAge(23);
			ses.saveOrUpdate(s3);
			
			Student s4=new Student();
			s4.setAge(42);
			ses.saveOrUpdate(s4);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
