package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* The LogicalExpression that we have created here will be treated like any other criterion. We can therefore add another restriction to the criteria */

public class CriteriaQuery_or_With_and_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria = ses.createCriteria(Student.class);
			Criterion criterion1 = Restrictions.gt("age", 30);
			Criterion criterion2 = Restrictions.eq("stdName", "Raja");
			LogicalExpression expression = Restrictions.or(criterion1, criterion2);
			criteria.add(expression);
			Criterion criterion3 = Restrictions.isNotNull("stdName");
			criteria.add(criterion3);
			List<Student> students1 = criteria.list();
			students1.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
