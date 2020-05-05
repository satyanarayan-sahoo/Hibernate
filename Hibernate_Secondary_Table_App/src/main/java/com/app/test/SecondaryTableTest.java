package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class SecondaryTableTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Employee emp=new Employee();
		emp.setEmpId(1010);
		emp.setFirstName("Raja");
		emp.setLastName("Babu");
		emp.setEmail("rajaji4444@gmail.com");
		emp.setSalary(50000);
		emp.setAddress("Marathahalli");
		ses.save(emp);
		
		Employee emp2=new Employee();
		emp2.setEmpId(1020);
		emp2.setFirstName("Abinash");
		emp2.setLastName("Samal");
		emp2.setEmail("abinash@gmail.com");
		emp2.setSalary(40000);
		emp2.setAddress("Bhubaneswar");
		ses.save(emp2);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
