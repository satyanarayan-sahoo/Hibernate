package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class DataInsertionTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			Employee emp1=new Employee();
			emp1.setEmpId(901);
			emp1.setEmpName("Raja");
			emp1.setEmpSal(50000);
			
			Employee emp2=new Employee();
			emp2.setEmpId(902);
			emp2.setEmpName("Rosy");
			emp2.setEmpSal(54000);
			
			Employee emp3=new Employee();
			emp3.setEmpId(903);
			emp3.setEmpName("Naresh");
			emp3.setEmpSal(50500);
			
			Employee emp4=new Employee();
			emp4.setEmpId(904);
			emp4.setEmpName("Bablu");
			emp4.setEmpSal(40000);
			
			Employee emp5=new Employee();
			emp5.setEmpId(905);
			emp5.setEmpName("Lipu");
			emp5.setEmpSal(54500);
			
			Employee emp6=new Employee();
			emp6.setEmpId(906);
			emp6.setEmpName("Jaga");
			emp6.setEmpSal(12500);
			
			ses.save(emp1);
			ses.save(emp2);
			ses.save(emp3);
			ses.save(emp4);
			ses.save(emp5);
			ses.save(emp6);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
