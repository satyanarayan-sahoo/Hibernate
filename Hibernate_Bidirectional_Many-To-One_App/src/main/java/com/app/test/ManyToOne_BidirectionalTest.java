package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.model.Address;
import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class ManyToOne_BidirectionalTest {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			String hql1 = "from com.app.model.Employee";
			Query query1 = ses.createQuery(hql1);
			List<Employee> employees = query1.getResultList();
			for (Employee e:employees) {
				System.out.println("Employee is: "+e+"--->Address is: "+e.getAdrs());
			}
			
			System.out.println("-------------------------------------------------------------");
			
			String hql2 = "from com.app.model.Address";
			Query query2 = ses.createQuery(hql2);
			List<Address> addresses = query2.getResultList();
			for (Address add:addresses) {
				System.out.println("Address is: "+add+"--->Employees are: "+add.getEmployees());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
