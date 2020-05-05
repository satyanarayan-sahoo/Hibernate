package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* To retrieve objects that have a property value that “equals” your restriction, use the eq() method on Restrictions,as 
   follows:Below  query will search all Students having name “Bablu”.
 * To retrieve objects that have a property value “not equal to” your restriction, use the ne() method on Restrictions, as 
   follows:Below  query will search all Students having name anything but not “Bablu”. */

public class CriteriaQuery_eq_ne_Test {

	public static void main(String[] args) {
		try (Session ses=HibernateUtil.getSf().openSession()){
			Criteria criteria1=ses.createCriteria(Student.class);
			criteria1.add(Restrictions.eq("stdName", "Bablu"));
			List<Student> students1=criteria1.list();
			students1.forEach(System.out::println);
			
			Criteria criteria2 = ses.createCriteria(Student.class);
			//criteria.add(Restrictions.ne("stdName", "Bablu"));
			Criterion criterion2 = Restrictions.ne("stdName", "Bablu");
			criteria2.add(criterion2);
			List<Student> students2= criteria2.list();
			students2.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
