package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* Here the test class is designed through try-with-resource(AutoClosebale pattern).Means no need to close session object,it can be close automatically */

public class Test {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		try(Session ses=sf.openSession()){
			Transaction tx=ses.beginTransaction();
			
			Student s=new Student();
			s.setStdId(104);
			s.setStdName("Papun");
			s.setStdFee(8765.34);
			s.setStdAge(25);
			ses.saveOrUpdate(s);
			
			tx.commit();
			sf.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
