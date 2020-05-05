package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* When we add more than one Criterion to a criteria query, it is interpreted as an AND. */

public class CriteriaQuery_and_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria = ses.createCriteria(Student.class);
			Criterion criterion1 = Restrictions.gt("age",25);
			Criterion criterion2 = Restrictions.isNotNull("stdName");
			criteria.add(criterion1);
			criteria.add(criterion2);
			List<Student> students = criteria.list();
			students.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
