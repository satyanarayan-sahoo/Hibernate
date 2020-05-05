package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

/* Here the page is shows always first row*/

public class PaginationTest4 {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()) {
			String hql="from com.app.model.Employee";
			Query q=ses.createQuery(hql);
			q.setFirstResult(0);
			q.setMaxResults(1);
			List<Employee> list=q.list();
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
