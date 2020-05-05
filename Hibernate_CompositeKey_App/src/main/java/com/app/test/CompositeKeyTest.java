package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.model.id.EmpId;
import com.app.util.HibernateUtil;

public class CompositeKeyTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			//Primary key Object value
			EmpId eid=new EmpId();
			eid.setEmpId(7777);
			eid.setEmpName("Raja");
			
			//Model class Object
			Employee emp=new Employee();
			emp.setEidPk(eid);
			emp.setEmpSal(50000);
			ses.save(emp);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
