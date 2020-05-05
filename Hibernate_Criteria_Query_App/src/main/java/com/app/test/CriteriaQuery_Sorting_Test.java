package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* Sorting the query’s results works much the same way with criteria as it would with HQL or SQL. The Criteria API provides the org.hibernate.criterion.Order
   class to sort your result set in either ascending or descending order, according to one of your object’s properties.
 * You may add more than one Order object to the Criteria object. Hibernate will pass them through to the underlying SQL query. 
   Your results will be sorted by the first order, then any identical matches within the first sort will be sorted by the second order, and so on. */

public class CriteriaQuery_Sorting_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria = ses.createCriteria(Student.class);
			Criterion criterion = Restrictions.gt("age", 23);
			criteria.add(criterion);
			criteria.addOrder(Order.desc("stdId"));
			List<Student> students = criteria.list();
			students.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
