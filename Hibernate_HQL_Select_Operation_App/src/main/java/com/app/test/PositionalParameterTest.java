package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.model.Manager;
import com.app.util.HibernateUtil;

//HQL supports positional Parameters starts from zero(0) [0,1,2...]

public class PositionalParameterTest {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSf();
	     try (Session ses=sf.openSession()){
	    	 String hql="from com.app.model.Manager where managerId=?0 or managerSalary=?1";
		     Query q=ses.createQuery(hql);
		     q.setParameter(0, 3001);
		     q.setParameter(1,45000);
		     List<Manager> list=q.list();
		     list.forEach(System.out::println);
		     sf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
