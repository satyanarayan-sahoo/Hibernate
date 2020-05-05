package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* One common application pattern that criteria can address is pagination through the result set of a database query. 
  There are two methods on the Criteria interface for paging, just as there are for Query: setFirstResult() and setMaxResults().
  The setFirstResult() method takes an integer that represents the first row in your result set, starting with row 0. 
  You can tell Hibernate to retrieve a fixed number of objects with the setMaxResults() method. 
  Using both of these together, we can construct a paging component in our web or Swing application. */

public class CriteriaQuery_Pagination_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria = ses.createCriteria(Student.class);
			criteria.setFirstResult(1);
			criteria.setMaxResults(3);
			List<Student> students = criteria.list();
			students.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
