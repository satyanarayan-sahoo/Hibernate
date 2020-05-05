package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.app.model.Manager;
import com.app.util.HibernateUtil;

public class NamedParameterTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			String hql="from com.app.model.Manager where managerName=:mname or managerSalary=:msalary";
			Query q=ses.createQuery(hql);
			q.setParameter("mname","Raja");
			q.setParameter("msalary",45000);
			List<Manager> list=q.list();
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
