package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/*In this example, I am retrieving StudentEntity object from database using hibernate session.As you can see that second “session.load()” statement does not
   execute select query again and load the Student entity directly from session cache.*/

public class Test1 {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		
		Session ses=sf.openSession();
		
		Student student=ses.load(Student.class,101);
		System.out.println(student);
		
		student=ses.load(Student.class,101);
		System.out.println(student);
		
		ses.close();
		sf.close();
	}//main

}//class
