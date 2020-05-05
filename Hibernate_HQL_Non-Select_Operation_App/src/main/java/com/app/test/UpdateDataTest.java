package com.app.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.util.HibernateUtil;

public class UpdateDataTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			//At a time one row is updated because here we are updating through primary key.
			String hql1="update com.app.model.Manager set managerName=:a,managerSalary=:b where managerId=:c";
			Query q1=ses.createQuery(hql1);
			q1.setParameter("a","Ramcharan");
			q1.setParameter("b",73000);
			q1.setParameter("c",3004);
			int count1=q1.executeUpdate();
			System.out.println(count1+" Row Updated");
			
			/*In this way we can update multiple row by using primary key. 
			At a time one row is updated because here we are updating through primary key.
			String hql1="update com.app.model.Manager set managerName=:a,managerSalary=:b where managerId=:c";
			Query q1=ses.createQuery(hql1);
			q1.setParameter("a","Ramcharan");
			q1.setParameter("b",73000);
			q1.setParameter("c",30004);
			int cnt1=q1.executeUpdate();
			System.out.println(cnt1+" Row Updated");
			q1.setParameter("a","Ram");
			q1.setParameter("b",56000);
			q1.setParameter("c",3001);
			int cnt2=q1.executeUpdate();
			System.out.println(cnt1+" Row Updated");*/
			
			//At a time multiple rows are updated because here we are not updating through primary key.
			String hql2="update com.app.model.Manager set managerSalary=:a where managerSalary>10000";
			Query q2=ses.createQuery(hql2);
			q2.setParameter("a",74000);
			int count2=q2.executeUpdate();
			System.out.println(count2+" Row Updated");
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
