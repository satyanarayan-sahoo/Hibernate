package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class SetMapCollectionTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Employee emp=new Employee();
		emp.setEmpId(501);
		emp.setEmpName("Raja");
		emp.getEmpData().add("D1");
		emp.getEmpData().add("D2");
		emp.getEmpData().add("D3");
		emp.getEmpAddrs().put(1,"Hyd");
		emp.getEmpAddrs().put(2,"Blr");
		ses.save(emp);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
