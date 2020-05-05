package com.app.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.util.HibernateUtil;

public class CopyDataTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			String hql="insert into com.app.model.ManagerBackup(managerIdBkp,managerNameBkp,managerSalaryBkp) select managerId,managerName,managerSalary from com.app.model.Manager";
			Query q=ses.createQuery(hql);
			int count=q.executeUpdate();
			System.out.println(count+" Row Updated");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
