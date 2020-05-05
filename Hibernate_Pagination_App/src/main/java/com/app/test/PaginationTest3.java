package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

/* Page is start from row no 3 and ends in row no 5.Total no of rows are 3. Here MaxResults() value is out of range */

public class PaginationTest3 {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()) {
			String hql="from com.app.model.Employee";
			Query q=ses.createQuery(hql);
			q.setFirstResult(3);
			q.setMaxResults(5);
			List<Employee> list=q.list();
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
