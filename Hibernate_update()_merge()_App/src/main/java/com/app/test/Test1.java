package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

public class Test1 {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		
		Student s=new Student();
		s.setStdId(101);
		s.setStdName("Raja");
		s.setStdFee(13000);
		s.setStdAge(23);
		
		//create ses1
		Session ses1=sf.openSession();
		Transaction tx1=ses1.beginTransaction();
		
		ses1.saveOrUpdate(s);
		
		tx1.commit();
		
		Transaction tx2=ses1.beginTransaction();
		s.setStdName("Raja Babu");
		ses1.update(s);
		tx2.commit();
		
		ses1.close();//s object in detached state now
		
		//create ses2
		Session ses2=sf.openSession();
		Transaction tx3=ses2.beginTransaction();
		
		s.setStdName("RRR");//Updated Name
		
		Student std=ses2.get(Student.class,101);//std object in persistent state with id 101
		System.out.println(std);
		
		/* Below we try to make on detached object with id 101 to persistent state by using update method of hibernate 
		 * It occurs the exception NonUniqueObjectException because std object is having student with same stdId as 101. 
		 * In order to avoid this exception we are using ses2.merge(s) method like given below instead of ses2.update(s) */
		//ses2.update(s); //-->Throws NonUniqueObjectException
		ses2.merge(s);//it merge the object state with std.
		
		//ses2.update(s); //-->Now also it Throws NonUniqueObjectException
		
		tx3.commit();
		ses2.close();
		
		sf.close();
	}//main

}//class
