package com.app.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.app.util.HibernateUtil;

public class NativeSqlWithoutAddEntityTest{

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			String sql="select * from employee_nativesql_tab";
			//SQLQuery q=ses.createSQLQuery(sql);
			NativeQuery q=ses.createNativeQuery(sql);
			List<Object[]> objs=q.list();
			for(Object[] ob:objs) {
				System.out.println(ob[0]+","+ob[1]+","+ob[2]);
			}//for
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
