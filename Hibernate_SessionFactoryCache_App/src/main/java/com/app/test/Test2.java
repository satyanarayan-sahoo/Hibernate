package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/*Explanation:Entity is present in first level cache so, it is fetched from there. No need to go to second level cache.*/

public class Test2 {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		
		Session ses=sf.openSession();
		
		Student student=ses.load(Student.class,102);
		System.out.println(student);
		
		student=ses.load(Student.class,102);
		System.out.println(student);
		
		ses.close();
		sf.close();
	}//main

}//class
