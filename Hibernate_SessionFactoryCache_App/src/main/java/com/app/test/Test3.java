package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* Explanation: First time entity is fetched from database. Which cause it store in 1st and 2nd level cache. Second load call fetched from first level cache. 
   Then we evicted entity from 1st level cache. So third load() call goes to second level cache*/

public class Test3 {

	public static void main(String[] args) {
        SessionFactory sf=HibernateUtil.getSf();
		
		Session ses=sf.openSession();
		
		Student student=ses.load(Student.class,103);
		System.out.println(student);
		
		student=ses.load(Student.class,103);
		System.out.println(student);
		
		ses.evict(student);
		
		student=ses.load(Student.class,103);
		System.out.println(student);
		
		ses.close();
		sf.close();
	}//main
	
}//class
