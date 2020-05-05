
package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Address;
import com.app.model.Employee;
import com.app.util.HibernateUtil;

/* Here many Employee has One Address */

public class ManyToOneTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Address addrs=new Address();
		addrs.setAddrsId(4321);
		addrs.setCity("Bangalore");
		addrs.setZipCode(560037);
		
		Employee emp1=new Employee();
		emp1.setEmployeeId(3001);
		emp1.setName("Raja");
		emp1.setSalary(50000);
		emp1.setAdrs(addrs);
		
		Employee emp2=new Employee();
		emp2.setEmployeeId(3002);
		emp2.setName("Lipu");
		emp2.setSalary(30000);
		emp2.setAdrs(addrs);
		
		Employee emp3=new Employee();
		emp3.setEmployeeId(3003);
		emp3.setName("Papun");
		emp3.setSalary(40000);
		emp3.setAdrs(addrs);
		
		Employee emp4=new Employee();
		emp4.setEmployeeId(3004);
		emp4.setName("Vicky");
		emp4.setSalary(50000);
		
		ses.save(emp1);
		ses.save(emp2);
		ses.save(emp3);
		ses.save(emp4);
		
		tx.commit();
		
		ses.close();
		sf.close();
	}//main

}//class
