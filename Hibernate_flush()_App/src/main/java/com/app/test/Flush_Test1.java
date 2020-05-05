package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* Put break point and observe console */

public class Flush_Test1 {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		try(Session ses=sf.openSession()){
			Transaction tx = ses.beginTransaction();
			
			Student student = ses.get(Student.class, 104);
			System.out.println(student.getStdName());
			System.out.println(student.getStdAge());
			System.out.println(student.getStdFee());
			
			student.setStdName("Salman");
			student.setStdAge(54);
			student.setStdFee(45000);
			ses.flush();
			
			student = ses.get(Student.class, 104);
			System.out.println(student.getStdName());
			System.out.println(student.getStdAge());
			System.out.println(student.getStdFee());
			
			tx.commit();
			ses.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
