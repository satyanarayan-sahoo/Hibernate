package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

/* Select Exactly rowId#4.Page is start from row no 4 and ends in row no 4.Total no of rows are 1 */

public class PaginationTest2 {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()) {
			String hql="from com.app.model.Employee";
			Query q=ses.createQuery(hql);
			q.setFirstResult(4);
			q.setMaxResults(1);
			List<Employee> list=q.list();
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
