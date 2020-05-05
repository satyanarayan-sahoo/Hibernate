package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* When we use custom generator that time if we pass primary key value manually also it is not stored in DataBase */

public class CustomGeneratorTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			Student s=new Student();
			s.setStdName("Raja");
			s.setStdFee(12000.500);
			s.setStdAge(23);
			ses.save(s);
			
			Student s1=new Student();
			s1.setStdName("Rosy");
			s1.setStdFee(11345.500);
			s1.setStdAge(17);
			ses.save(s1);
			
			Student s2=new Student();
			s2.setStdId("107");
			s2.setStdName("Naresh");
			s2.setStdFee(777.500);
			s2.setStdAge(24);
			ses.save(s2);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
