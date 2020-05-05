package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/*Explanation: When another session created from same session factory try to get entity, it is successfully looked up in second level cache and no database 
  call is made.*/

public class Test4 {

	public static void main(String[] args) {
        SessionFactory sf=HibernateUtil.getSf();
		
		Session ses1=sf.openSession();
		Session ses2=sf.openSession();
		
		Student student=ses1.load(Student.class,104);
		System.out.println(student);
		
		student=ses1.load(Student.class,104);
		System.out.println(student);
		
		ses1.evict(student);
		
		student=ses1.load(Student.class,104);
		System.out.println(student);
		
		student=ses2.load(Student.class,104);
		System.out.println(student);
		
		ses1.close();
		ses2.close();
		sf.close();
	}//main

}//class
