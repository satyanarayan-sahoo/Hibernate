package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* If you want obtain a single Object reference instead of a List, the uniqueResult() method on the Criteria object returns an object or null.
   If there is more than one result, the uniqueResult() method throws a HibernateException.
 * Please note that you need to make sure that your query returns only one or zero results if you use the uniqueResult() method. Otherwise, Hibernate will
   throw a NonUniqueResultException exception.
 * The following short example demonstrates having a result set that would have included more than one result, except that it was limited with the 
   setMaxResults() method */

public class CriteriaQuery_UniqueResult_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria1 = ses.createCriteria(Student.class);
			Criterion criterion1 = Restrictions.gt("age", 25);
			criteria1.add(criterion1);
			criteria1.setMaxResults(1);
			Student student1 = (Student) criteria1.uniqueResult();
			/*List<Student> students =criteria.list();
			students.forEach(System.out::println);*/
			System.out.println(student1);
			
			Criteria criteria2 = ses.createCriteria(Student.class);
			Criterion criterion2 = Restrictions.gt("age", 30);
			criteria2.add(criterion2);
			Student student2 = (Student) criteria2.uniqueResult();
			System.out.println(student2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
