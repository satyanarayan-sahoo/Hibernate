package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* Put break point and observe console */

public class Flush_Test2 {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSf();
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
			
		Student student1 = new Student();
		student1.setStdId(1001);
		student1.setStdName("Raja Babu");
		student1.setStdAge(23);
		student1.setStdFee(65000);
			
		ses.save(student1);
			
		Student student2 = ses.get(Student.class, 1001);
		System.out.println(student2.getStdName());
		System.out.println(student2.getStdAge());
		System.out.println(student2.getStdFee());
			
		ses.flush();
			
		student2 = ses.get(Student.class, 1001);
		System.out.println(student2.getStdName());
		System.out.println(student2.getStdAge());
		System.out.println(student2.getStdFee());
			
		ses.clear();
			
		student2 = ses.get(Student.class, 1001);
		System.out.println(student2.getStdName());
		System.out.println(student2.getStdAge());
		System.out.println(student2.getStdFee());
		
		Session ses2 = sf.openSession();
		
		Student student3 = ses2.get(Student.class, 1001);
		System.out.println(student3.getStdName());
		System.out.println(student3.getStdAge());
		System.out.println(student3.getStdFee());
			
		tx.commit();
			
	}//main

}//class
