package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* Instead of searching for exact matches, we can retrieve all objects that have a property matching part of a given pattern.
   To do this, we need to create an SQL LIKE clause, with either the like() or the ilike() method. The ilike() method is case-insensitive. 
 * Below example uses an org.hibernate.criterion.MatchMode object to specify how to match the specified value to the stored data.
   The MatchMode object (a type-safe enumeration) has four different matches:
     ANYWHERE: Match the pattern anywhere in the string.
     END: Match the end of the string to the pattern.
     EXACT: Match the entire string to the pattern.
     START: Match the start of the string to the pattern.*/

public class CriteriaQuery_like_ilike_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria1 = ses.createCriteria(Student.class);
			Criterion criterion1 = Restrictions.ilike("stdName", "Blu", MatchMode.ANYWHERE);
			criteria1.add(criterion1);
			List<Student> students1= criteria1.list();
			students1.forEach(System.out::println);
			
			Criteria criteria2 = ses.createCriteria(Student.class);
			Criterion criterion2 = Restrictions.like("stdName", "blu", MatchMode.ANYWHERE);
			criteria2.add(criterion2);
			List<Student> students2= criteria2.list();
			students2.forEach(System.out::println);
			
			Criteria criteria3 = ses.createCriteria(Student.class);
			Criterion criterion3 = Restrictions.ilike("stdName", "pun", MatchMode.END);
			criteria3.add(criterion3);
			List<Student> students3= criteria3.list();
			students3.forEach(System.out::println);
			
			Criteria criteria4 = ses.createCriteria(Student.class);
			Criterion criterion4 = Restrictions.ilike("stdName", "ra", MatchMode.START);
			criteria4.add(criterion4);
			List<Student> students4= criteria4.list();
			students4.forEach(System.out::println);
			
			Criteria criteria5 = ses.createCriteria(Student.class);
			Criterion criterion5 = Restrictions.ilike("stdName", "lipu", MatchMode.EXACT);
			criteria5.add(criterion5);
			List<Student> students5= criteria5.list();
			students5.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
