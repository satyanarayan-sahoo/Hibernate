package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Manager;
import com.app.util.HibernateUtil;

// Insert Multiple records.

public class InsertDataTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Manager m1=new Manager();
		m1.setManagerId(3001);
		m1.setManagerName("Raja");
		m1.setManagerSalary(50000);
		
		Manager m2=new Manager();
		m2.setManagerId(3002);
		m2.setManagerName("Naresh");
		m2.setManagerSalary(45000);
		
		Manager m3=new Manager();
		m3.setManagerId(3003);
		m3.setManagerName("Papun");
		m3.setManagerSalary(40000);
		
		Manager m4=new Manager();
		m4.setManagerId(3004);
		m4.setManagerName("Vicky");
		m4.setManagerSalary(45000);
		
		ses.save(m1);
		ses.save(m2);
		ses.save(m3);
		ses.save(m4);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
