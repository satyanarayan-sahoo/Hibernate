package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.app.util.HibernateUtil;

//Select one record only

public class SelectOneColumnsTest {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			String hql="select managerName from com.app.model.Manager";
			Query q=ses.createQuery(hql);
			List<String> list=q.list();
			for(String s:list) {
				System.out.println(s);
			}//for
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
