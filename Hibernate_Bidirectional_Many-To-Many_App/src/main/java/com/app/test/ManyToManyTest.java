package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Course;
import com.app.model.Student;
import com.app.util.HibernateUtil;

/* Here Multiple Student are taken multiple Course */

public class ManyToManyTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Course c1=new Course();
		c1.setCourseId(601);
		c1.setCourseName("Java");
		c1.setCourseFee(3500);
		
		Course c2=new Course();
		c2.setCourseId(602);
		c2.setCourseName("Python");
		c2.setCourseFee(7000);
		
		Course c3=new Course();
		c3.setCourseId(603);
		c3.setCourseName("Android");
		c3.setCourseFee(10000);
		
		Student s1=new Student();
		s1.setStudentId(7001);
		s1.setStudentName("Raja");
		s1.setStudentMark(462);
		s1.getCourse().add(c1);
		s1.getCourse().add(c2);
		
		Student s2=new Student();
		s2.setStudentId(7002);
		s2.setStudentName("Lipu");
		s2.setStudentMark(399);
		s2.getCourse().add(c2);
		s2.getCourse().add(c3);
		
		Student s3=new Student();
		s3.setStudentId(7003);
		s3.setStudentName("Papun");
		s3.setStudentMark(450);
		s3.getCourse().add(c3);
		
		Student s4=new Student();
		s4.setStudentId(7004);
		s4.setStudentName("RRR");
		s4.setStudentMark(4540);
		
		ses.save(s1);
		ses.save(s2);
		ses.save(s3);
		ses.save(s4);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
