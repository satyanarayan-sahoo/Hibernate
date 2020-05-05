package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;


public class SequenceGeneratorTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			Employee emp1=new Employee();
			emp1.setEmpName("RajaBabu");
			emp1.setEmpSal(65000);
			int eid1=(int) ses.save(emp1);
			System.out.println("Employee id is:"+eid1);
			
			Employee emp2=new Employee();
			emp2.setEmpName("Mahesh");
			emp2.setEmpSal(45678);
			int eid2=(int) ses.save(emp2);
			System.out.println("Employee id is:"+eid2);
			
			Employee emp3=new Employee();
			emp3.setEmpName("Prabhas");
			emp3.setEmpSal(76453);
			ses.persist(emp3);
			
			Employee emp4=new Employee();
			emp4.setEmpName("Vijay");
			emp4.setEmpSal(97345);
			ses.saveOrUpdate(emp4);
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
