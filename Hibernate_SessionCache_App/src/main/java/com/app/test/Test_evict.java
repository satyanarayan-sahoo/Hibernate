package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/*Here evict() is used to remove a particular object from cache associated with session,So it is essentially like remove,
  evict() method removed the Student1 object from cache so that it was fetched again from database.*/

public class Test_evict {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		
		Session ses=sf.openSession();
		
		Student student=ses.load(Student.class,101);
		System.out.println(student);
		
		student=ses.load(Student.class,101);
		System.out.println(student);
		
		Student student1=ses.load(Student.class,102);
		System.out.println(student1);
		
		ses.evict(student1);
		
		student=ses.load(Student.class,101);
		System.out.println(student);
		
		student1=ses.load(Student.class,102);
		System.out.println(student1);
		
		ses.close();
		sf.close();
	}//main

}//class
