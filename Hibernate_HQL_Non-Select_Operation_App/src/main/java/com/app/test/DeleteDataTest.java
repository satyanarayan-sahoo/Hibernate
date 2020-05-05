package com.app.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.util.HibernateUtil;

public class DeleteDataTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			//At a time one row is deleted because here we are deleting through primary key.
			String hql="delete from com.app.model.Manager where managerId=:a";
			Query q=ses.createQuery(hql);
			q.setParameter("a",3001);
			int count=q.executeUpdate();
			tx.commit();
			System.out.println(count+" Row Updated");
			
			
			//At a time multiple rows are deleted
			Transaction tx2=ses.beginTransaction();
			String hql2="delete from com.app.model.Manager where managerSalary=:a";
			Query q2=ses.createQuery(hql2);
			q2.setParameter("a",45000);
			int count2=q2.executeUpdate();
			tx2.commit();
			System.out.println(count2+" Row Updated");
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
