package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class IdBagTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			Employee emp=new Employee();
			emp.setEmpId(8001);
			emp.setEmpName("Raja");
			emp.setEmpSal(62000);
			emp.getEmpProj().add("Lumin");
			emp.getEmpProj().add("Integration");
			emp.getEmpProj().add("io");
			
			ses.save(emp);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
