package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.model.Person;
import com.app.model.Student;
import com.app.util.HibernateUtil;

/*  number of Sub Class and parrent class=number of tables in the DataBase
 *  Here parrent class data will stored in parrent class table and sub class data will stored in sub class table*/

public class TablePerSubClassTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Person per=new Person();
		per.setPersonId(1001);
		per.setFirstName("Raj");
		per.setLastname("Babu");
		
		Employee emp1=new Employee();
		emp1.setPersonId(2001);
		emp1.setFirstName("Satyanarayan");
		emp1.setLastname("Sahoo");
		emp1.setSalary(50000);
		
		Employee emp2=new Employee();
		emp2.setPersonId(2002);
		emp2.setFirstName("Satya");
		emp2.setLastname("Sahoo");
		emp2.setSalary(7650);
		
		Student std1=new Student();
		std1.setPersonId(3001);
		std1.setFirstName("Rojalin");
		std1.setLastname("Sahoo");
		std1.setFee(12000);
		std1.setGrade("A");
		
		Student std2=new Student();
		std2.setPersonId(3002);
		std2.setFirstName("Roja");
		std2.setLastname("Sahoo");
		std2.setFee(17000);
		std2.setGrade("O");
		
		ses.save(per);
		ses.save(emp1);
		ses.save(emp2);
		ses.save(std1);
		ses.save(std2);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
