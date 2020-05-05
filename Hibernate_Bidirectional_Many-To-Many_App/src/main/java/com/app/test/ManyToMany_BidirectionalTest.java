package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.model.Course;
import com.app.model.Student;
import com.app.util.HibernateUtil;

public class ManyToMany_BidirectionalTest {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			String hql1 = "from com.app.model.Student";
			Query query1 = ses.createQuery(hql1);
			List<Student> students = query1.list();
			for (Student std:students) {
				System.out.println("Student is: "+std+"--->Course are: "+std.getCourse());
			}
			
			System.out.println("-------------------------------------------------------------");
			
			String hql2 = "from com.app.model.Course";
			Query query2 = ses.createQuery(hql2);
			List<Course> courses = query2.list();
			for (Course c:courses) {
				System.out.println("Course is: "+c+"--->Students are: "+c.getStudent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
