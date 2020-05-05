package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* sqlRestriction() restriction allows you to directly specify SQL in the Criteria API. It’s useful if you need to use SQL clauses that Hibernate does not
   support through the Criteria API.
 * Your application’s code does not need to know the name of the table your class uses. Use {alias} to signify the class’s table, as follows: */

public class CriteriaQuery_sqlRestriction_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria = ses.createCriteria(Student.class);
			Criterion criterion = Restrictions.sqlRestriction("sname='Raja' or age=40");
			//Criterion criterion = Restrictions.sqlRestriction("{alias}.sname='Raja' or {alias}.age=40");
			criteria.add(criterion);
			List<Student> students = criteria.list();
			students.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
