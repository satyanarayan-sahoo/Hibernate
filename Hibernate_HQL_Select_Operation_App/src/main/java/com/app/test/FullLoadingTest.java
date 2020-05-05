package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.app.model.Manager;
import com.app.util.HibernateUtil;

// Full Loading

public class FullLoadingTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			String hql="from com.app.model.Manager";
			Query q=ses.createQuery(hql);
			List<Manager> man=q.list();
			/*for(Manager m:man) {
				System.out.println(m);
			}//for*/
			man.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
