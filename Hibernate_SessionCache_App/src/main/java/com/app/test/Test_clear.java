package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/*Here  clear() method is used to remove all cached objects associated with session.So it is essentially like remove all.
  clear() method removed all the Student object from cache so that again these are fetched again from database.*/

public class Test_clear {
	public static void main(String[] args) {
			SessionFactory sf=HibernateUtil.getSf();
			
			Session ses=sf.openSession();
			
			Student student=ses.load(Student.class,101);
			System.out.println(student);
			
			student=ses.load(Student.class,101);
			System.out.println(student);
			
			Student student1=ses.load(Student.class,102);
			System.out.println(student1);
			
			ses.clear();
			
			student=ses.load(Student.class,101);
			System.out.println(student);
			
			student1=ses.load(Student.class,102);
			System.out.println(student1);
			
			ses.close();
			sf.close();
	}//main
}//class
