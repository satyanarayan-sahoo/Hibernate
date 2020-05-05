package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/*With new session, entity is fetched from database again irrespective of it is already present in any other session in application.
  You can see that even if the Student entity was stored in “ses1” object, still another database query was executed when we use another session object
   “ses2”.*/

public class Test2 {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		
		Session ses1=sf.openSession();
		Session ses2=sf.openSession();
		
		Student student1=ses1.load(Student.class,101);
		System.out.println(student1);
		
		student1=ses1.load(Student.class,101);
		System.out.println(student1);
		
		Student student2=ses2.load(Student.class,101);
		System.out.println(student2);
		
		ses1.close();
		ses2.close();
		sf.close();
	}//main

}//class
