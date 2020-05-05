package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* If we wanted to create an OR expression with more than two different criteria (for example, age > 30 OR stdName Lipu OR stdId<112),
    we would use an org.hibernate.criterion.Disjunction object to represent a disjunction.
 * You can obtain this object from the disjunction() factory method on the Restrictions class. The disjunction is more convenient than building a tree of
   OR expressions in code. To represent an AND expression with more than two criteria, you can use the conjunction() method, although you can easily just
   add those to the Criteria object. The conjunction can be more convenient than building a tree of AND expressions in code. Here is an example that uses
   the disjunction */

public class CriteriaQuery_MorethanTwo_or_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria = ses.createCriteria(Student.class);
			Criterion criterion1 = Restrictions.gt("age", 30);
			Criterion criterion2 = Restrictions.eq("stdName", "Lipu");
			Criterion criterion3 = Restrictions.lt("stdId",112);
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(criterion1);
			disjunction.add(criterion2);
			disjunction.add(criterion3);
			criteria.add(disjunction);
			List<Student> students1 = criteria.list();
			students1.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
