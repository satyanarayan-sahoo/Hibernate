package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/*Explanation: Entity is not present in either 1st or 2nd level cache so, it is fetched from database.*/

public class Test1 {

	public static void main(String[] args) {
        SessionFactory sf=HibernateUtil.getSf();
		
		Session ses=sf.openSession();
		
		Student student=ses.load(Student.class,101);
		System.out.println(student);
		
		ses.close();
		sf.close();
	}//main

}//class
