package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.app.util.HibernateUtil;

public class NativeSqlUpdateTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Transaction tx=ses.beginTransaction();
			
			String sql="update employee_nativesql_tab set ename=:a,esal=:b where eid=:c";
			NativeQuery q=ses.createNativeQuery(sql);
			//SQLQuery q=ses.createSQLQuery(sql);
			q.setParameter("a","Naresh");
			q.setParameter("b",43000);
			q.setParameter("c",103);
			int count=q.executeUpdate();
			tx.commit();
			System.out.println(count+" Row Updated");
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
