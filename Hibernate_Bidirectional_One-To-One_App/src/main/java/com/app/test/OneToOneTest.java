package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Address;
import com.app.model.Employee;
import com.app.util.HibernateUtil;

/* Here One Employee has One Address */

public class OneToOneTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Address addrs1=new Address();
		addrs1.setAddrsId(1111);
		addrs1.setCity("Bangalore");
		addrs1.setZipCode(560037);
		
		Address addrs2=new Address();
		addrs2.setAddrsId(2222);
		addrs2.setCity("Bhuban");
		addrs2.setZipCode(759017);
		
		Employee emp1=new Employee();
		emp1.setEmployeeId(101);
		emp1.setName("Raja");
		emp1.setSalary(50000);
		emp1.setAddrs(addrs1);
		
		Employee emp2=new Employee();
		emp2.setEmployeeId(202);
		emp2.setName("Rosy");
		emp2.setSalary(500);
		emp2.setAddrs(addrs2);
		
		Employee emp3=new Employee();
		emp3.setEmployeeId(203);
		emp3.setName("Lipu");
		emp3.setSalary(600);
		
		Employee emp4=new Employee();
		emp4.setEmployeeId(204);
		emp4.setName("Vicky");
		emp4.setSalary(700);
		
		ses.save(emp1);
		ses.save(emp2);
		ses.save(emp3);
		ses.save(emp4);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
