package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class BagTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			Employee emp=new Employee();
			emp.setEmpId(7071);
			emp.setEmpName("Raja");
			emp.setEmpSal(60000);
			emp.getEmpProj().add("Lumin");
			emp.getEmpProj().add("io");
			emp.getEmpProj().add("WAS");
			
			ses.save(emp);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
