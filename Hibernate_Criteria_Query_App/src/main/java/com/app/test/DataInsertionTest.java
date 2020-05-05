package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

public class DataInsertionTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			Student s1=new Student();
			s1.setStdId(111);
			s1.setStdName("Raja");
			s1.setStdCourse("Java");
			s1.setAge(23);
			
			Student s2=new Student();
			s2.setStdId(112);
			s2.setStdName("Papun");
			s2.setStdCourse(".Net");
			s2.setAge(25);
			
			Student s3=new Student();
			s3.setStdId(113);
			s3.setStdName("Lipu");
			s3.setStdCourse("UI");
			s3.setAge(28);
			
			Student s4=new Student();
			s4.setStdId(114);
			s4.setStdName("Bablu");
			s4.setStdCourse("Android");
			s4.setAge(30);
			
			Student s5=new Student();
			s5.setStdId(115);
			s5.setStdCourse("BSC");
			s5.setAge(40);
			
			Student s6=new Student();
			s6.setStdId(116);
			s6.setStdName("Naresh");
			s6.setStdCourse("Costing");
			s6.setAge(23);
			
			ses.save(s1);
			ses.save(s2);
			ses.save(s3);
			ses.save(s4);
			ses.save(s5);
			ses.save(s6);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
