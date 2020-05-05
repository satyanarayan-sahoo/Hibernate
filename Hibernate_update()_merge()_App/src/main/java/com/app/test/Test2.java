package com.app.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

public class Test2 {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSf();
		
		Session ses1 = sf.openSession();
		Student s1 = ses1.get(Student.class, 101);
		System.out.println("s1 object is:"+s1);
		ses1.close();
		
		s1.setStdName("Satyanarayan Sahoo");
		Session ses2 = sf.openSession();
		Transaction tx = ses2.beginTransaction();
		Student s2 = ses2.get(Student.class, 101);
		//ses2.update(s1); -->Exception comes
		
		ses2.merge(s2);
		tx.commit();
		ses2.close();
		
		sf.close();
	}//main

}//class
