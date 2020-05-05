package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* If we want to have two restrictions that return objects that satisfy either or both of the restrictions, we need to use LogicalExpression.This is act as OR. */

public class CriteriaQuery_or_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria = ses.createCriteria(Student.class);
			Criterion criterion1 = Restrictions.gt("age", 30);
			Criterion criterion2 = Restrictions.eq("stdName", "Raja");
			LogicalExpression expression = Restrictions.or(criterion1, criterion2);
			criteria.add(expression);
			List<Student> students1 = criteria.list();
			students1.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
