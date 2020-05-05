package com.app.test;

import org.hibernate.Query;
import org.hibernate.Session;
import com.app.util.HibernateUtil;

// Retriving One Row and One Column by using uniqueResult()

public class UniqueResultOneRowOneColumnTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			String hql="select managerName from com.app.model.Manager where managerId=:a";
			Query q=ses.createQuery(hql);
			q.setParameter("a",3002);
			String m=(String) q.uniqueResult();
			System.out.println(m);
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
