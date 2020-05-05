package com.app.test;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.model.Person;
import com.app.model.Student;
import com.app.util.HibernateUtil;

/*  Here in this case only one table is created for all parrent class and sub classes*/

public class TablePerClassHierarchyTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Person per=new Person();
		per.setPersonId(501);
		per.setFirstName("Raja");
		per.setLastName("Babu");
		per.setAge(23);
		
		Student std=new Student();
		std.setAge(601);
		std.setFirstName("Rojalin");
		std.setLastName("Sahoo");
		std.setAge(17);
		std.setCourse("BSC");
		std.setFee(12000);
		
		Employee emp=new Employee();
		emp.setPersonId(701);
		emp.setFirstName("Satyanarayan");
		emp.setLastName("Sahoo");
		emp.setAge(23);
		emp.setJoiningDate(new Date());
		emp.setDepartmentName("Software");
		
		ses.save(per);
		ses.save(std);
		ses.save(emp);
		tx.commit();
		
		ses.close();
		sf.close();
	}//main

}//class
