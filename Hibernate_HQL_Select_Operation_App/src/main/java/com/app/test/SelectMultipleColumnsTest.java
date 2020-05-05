package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.app.util.HibernateUtil;

// Select Multiple records

public class SelectMultipleColumnsTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			String hql="select managerName,managerSalary from com.app.model.Manager";
			Query q=ses.createQuery(hql);
			List<Object[]> list=q.list();
			for(Object[] obj:list) {
				System.out.println(obj[0]+","+obj[1]);
			}//for
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
