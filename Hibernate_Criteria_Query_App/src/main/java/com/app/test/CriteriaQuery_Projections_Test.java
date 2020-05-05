package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* 1.avg(String propertyName): Gives the average of a property’s value.
   2.count(String propertyName): Counts the number of times a property occurs.
   3.countDistinct(String propertyName): Counts the number of unique values the property contains.
   4.max(String propertyName): Calculates the maximum value of the property values.
   5.min(String propertyName): Calculates the minimum value of the property values.
   6.sum(String propertyName): Calculates the sum total of the property values.
   7.rowCount(): counts the total number of rows.
   8.id(): gives the ids.
   9.distinct(projection): to find the distinct values of a particular property. */

public class CriteriaQuery_Projections_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria1 = ses.createCriteria(Student.class);
			criteria1.setProjection(Projections.rowCount());
			List count1 = criteria1.list();
			count1.forEach(System.out::println);
			
			Criteria criteria2 = ses.createCriteria(Student.class);
			criteria2.setProjection(Projections.countDistinct("age"));
			List count2 = criteria2.list();
			count2.forEach(System.out::println);
			
			Criteria criteria3 = ses.createCriteria(Student.class);
			criteria3.setProjection(Projections.count("stdName"));
			List count3 = criteria3.list();
			count3.forEach(System.out::println);
			

			Criteria criteria4 = ses.createCriteria(Student.class);
			criteria4.setProjection(Projections.max("age"));
			List maxAge = criteria4.list();
			maxAge.forEach(System.out::println);
			
			Criteria criteria5 = ses.createCriteria(Student.class);
			criteria5.setProjection(Projections.min("age"));
			List minAge = criteria5.list();
			minAge.forEach(System.out::println);
			
			Criteria criteria6 = ses.createCriteria(Student.class);
			criteria6.setProjection(Projections.sum("age"));
			List sumAge = criteria6.list();
			sumAge.forEach(System.out::println);
			
			Criteria criteria7 = ses.createCriteria(Student.class);
			criteria7.setProjection(Projections.avg("age"));
			List avgAge = criteria7.list();
			avgAge.forEach(System.out::println);
			
			Criteria criteria8 = ses.createCriteria(Student.class);
			criteria8.setProjection(Projections.id());
			List ids = criteria8.list();
			ids.forEach(System.out::println);
			
			Criteria criteria9 = ses.createCriteria(Student.class);
			Projection projection = Projections.property("age");
			criteria9.setProjection(Projections.distinct(projection));
			List distinctAges = criteria9.list();
			distinctAges.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
