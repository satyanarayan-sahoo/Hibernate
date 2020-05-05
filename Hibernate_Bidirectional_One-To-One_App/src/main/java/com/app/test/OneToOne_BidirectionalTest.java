package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.model.Address;
import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class OneToOne_BidirectionalTest {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			String hql1 = "from com.app.model.Employee";
			Query query1 = ses.createQuery(hql1);
			List<Employee> employees = query1.list();
			for (Employee e:employees) {
				System.out.println("Employee is: "+e+"--->Address is: "+e.getAddrs());
			}
			
			System.out.println("-------------------------------------------------------------");
			
			String hql2 = "from com.app.model.Address";
			Query query2 = ses.createQuery(hql2);
			List<Address> addresses = query2.list();
			for (Address add:addresses) {
				System.out.println("Address is: "+add+"--->Employees is: "+add.getEmp());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
