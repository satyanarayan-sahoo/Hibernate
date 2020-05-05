package com.app.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class NamedQueryTest {

	public static void main(String[] args) {
		try(Session ses1 = HibernateUtil.getSf().openSession();Session ses2 = HibernateUtil.getSf().openSession()) {
			Transaction tx = ses1.beginTransaction();
			
			Query query1 = ses1.getNamedQuery(Employee.UPDATE_EMPLOYEE_BY_ID)
				       .setParameter("name", "Satyanarayan Sahoo")
				       .setParameter("sal", 55000)
				       .setParameter("id", 101);
		    query1.executeUpdate();
		    tx.commit();
			
			Query query2 = ses2.getNamedQuery(Employee.GET_EMPLOYEE_BY_ID).setParameter("id", 101);
			Employee employee = (Employee) query2.uniqueResult();
			System.out.println(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
