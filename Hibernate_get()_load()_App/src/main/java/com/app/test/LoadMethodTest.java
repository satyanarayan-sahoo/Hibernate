package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.model.Student;

/* In the below code, we have used session.load() to retrieve the Student with the ID 101, Hibernate immediately created the fake Student object with the Id 101
   and the remaining properties (Name, Age, Fee) would not have been initialized till now.It returns the dummy object to the application.so that we can see the
   StdId 101,here no DB call happens.  
   It will hit the database only when it tries to retrieve other properties of Student object i.e; student.getStdName() or student.getStdAge() or 
   student.getStdFee().When the object with the id 101 is not found in the database, it will throw “ObjectNotFoundException”.
   This is the reason, we did not see the below SQL query when we retrieved student id (student.getStdId()).*/

public class LoadMethodTest {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		
		Student student=(Student)ses.load(Student.class,101);
		System.out.println("*** Student Details ***");
		System.out.println("Student Id:"+student.getStdId());
		
		System.out.println("Till now no DB call happens");
		
		System.out.println("Student Name:"+student.getStdName());
		System.out.println("Student Age:"+student.getStdAge());
		System.out.println("Student Fee:"+student.getStdFee());
		
		System.out.println("--------------------------------------");
		
		//Now no DB call happened.Object is load from session cache.
		Student student2=(Student)ses.load(Student.class,101);
		System.out.println("*** Student2 Details ***");
		System.out.println("Student2 Id:"+student2.getStdId());
		System.out.println("Student2 Name:"+student2.getStdName());
		System.out.println("Student2 Age:"+student2.getStdAge());
		System.out.println("Student2 Fee:"+student2.getStdFee());
		
		ses.close();
		sf.close();
	}//main

}//class
