package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class NativeSqlQueryInsertionTest {
	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			Employee emp1=new Employee();
			emp1.setEmpId(101);
			emp1.setEmpName("Raja");
			emp1.setEmpSal(63000);
			

			Employee emp2=new Employee();
			emp2.setEmpId(102);
			emp2.setEmpName("Papun");
			emp2.setEmpSal(40000);
			

			Employee emp3=new Employee();
			emp3.setEmpId(103);
			emp3.setEmpName("Vicky");
			emp3.setEmpSal(45000);
			
			ses.save(emp1);
			ses.save(emp2);
			ses.save(emp3);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main
}//class
