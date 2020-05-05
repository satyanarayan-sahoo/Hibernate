package com.app.test;

import org.hibernate.Query;
import org.hibernate.Session;
import com.app.model.Manager;
import com.app.util.HibernateUtil;

// Retriving One row by using uniqueResult()

public class UniqueResultOneRowTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			String hql="from com.app.model.Manager where managerId=:a";
			Query q=ses.createQuery(hql);
			q.setParameter("a",3001);
			Manager m=(Manager) q.uniqueResult();
			System.out.println(m);
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
