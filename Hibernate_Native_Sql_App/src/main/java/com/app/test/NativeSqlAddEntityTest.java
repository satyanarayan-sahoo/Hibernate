package com.app.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class NativeSqlAddEntityTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			String sql="select * from employee_nativesql_tab";
			NativeQuery q=ses.createNativeQuery(sql);
			//SQLQuery q=ses.createSQLQuery(sql);
			q.addEntity(Employee.class);
			List<Employee> emp = q.list();
			emp.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
