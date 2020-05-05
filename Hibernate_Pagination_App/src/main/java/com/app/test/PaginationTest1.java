package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

/* Page is start from row no 2 and ends in row no 5.Total no of rows are 4 */

public class PaginationTest1 {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()) {
			String hql="from com.app.model.Employee";
			Query q=ses.createQuery(hql);
			q.setFirstResult(2);
			q.setMaxResults(4);
			List<Employee> list=q.list();
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
