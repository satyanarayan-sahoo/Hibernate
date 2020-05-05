package com.app.test;

import org.hibernate.Query;
import org.hibernate.Session;
import com.app.util.HibernateUtil;

// Retriving One Row and Multiple Column by using uniqueResult()

public class UniqueResultOneRowMultipleColumnTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			String hql="select managerName,managerSalary from com.app.model.Manager where managerId=:a";
			Query q=ses.createQuery(hql);
			q.setParameter("a",3003);
			Object[] m=(Object[]) q.uniqueResult();
			System.out.println(m[0]+","+m[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
