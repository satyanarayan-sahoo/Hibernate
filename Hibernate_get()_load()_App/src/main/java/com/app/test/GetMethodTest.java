package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.model.Student;

/* In the below code, we have used session.get() to retrieve the Student with the ID 102, Hibernate immediately hits the database and returns the original 
   Student object. This is the reason, we are getting the below SQL query immediately when we retrieve the Student id (student.getStdId()).*/

public class GetMethodTest {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		
		Student student=ses.get(Student.class,102);
		System.out.println("*** Student Details ***");
		System.out.println("Student Id:"+student.getStdId());
		
		System.out.println("DB call happens");
		
		System.out.println("Student Name:"+student.getStdName());
		System.out.println("Student Age:"+student.getStdAge());
		System.out.println("Student Fee:"+student.getStdFee());
		
		System.out.println("----------------------------------------");
		
		//Now DB call not happened.This time it takes from session cache.
		Student student2=ses.get(Student.class,102);
		System.out.println("*** Student2 Details ***");
		System.out.println("Student2 Id:"+student2.getStdId());
		System.out.println("Student2 Name:"+student2.getStdName());
		System.out.println("Student2 Age:"+student2.getStdAge());
		System.out.println("Student2 Fee:"+student2.getStdFee());
		
		ses.close();
		sf.close();
	}//main

}//class
