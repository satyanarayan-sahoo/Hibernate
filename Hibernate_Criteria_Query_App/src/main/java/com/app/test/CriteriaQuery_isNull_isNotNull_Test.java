package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* The isNull() and isNotNull() restrictions allow you to do a search for objects that have (or do not have) null property values. */

public class CriteriaQuery_isNull_isNotNull_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria1 = ses.createCriteria(Student.class);
			Criterion criterion1 = Restrictions.isNull("stdName");
			criteria1.add(criterion1);
			List<Student> students1 = criteria1.list();
			students1.forEach(System.out::println);
			
			Criteria criteria2 = ses.createCriteria(Student.class);
			Criterion criterion2 = Restrictions.isNotNull("stdName");
			criteria2.add(criterion2);
			List<Student> students2 = criteria2.list();
			students2.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
