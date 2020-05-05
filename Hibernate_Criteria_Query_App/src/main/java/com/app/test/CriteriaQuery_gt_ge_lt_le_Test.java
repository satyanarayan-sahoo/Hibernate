package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.app.model.Student;
import com.app.util.HibernateUtil;

/* Several of the restrictions are useful for doing math comparisons. The greater-than comparison is gt(), the greater-than-or-equal-to comparison is ge(),
   the less-than comparison is lt(), and the less-than-or-equal-to comparison is le(). */

public class CriteriaQuery_gt_ge_lt_le_Test {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Criteria criteria1 = ses.createCriteria(Student.class);
			Criterion criterion1 = Restrictions.gt("age", 25);
			criteria1.add(criterion1);
			List<Student> students1 = criteria1.list();
			students1.forEach(System.out::println);
			
			Criteria criteria2 = ses.createCriteria(Student.class);
			Criterion criterion2 = Restrictions.ge("age", 25);
			criteria2.add(criterion2);
			List<Student> students2 = criteria2.list();
			students2.forEach(System.out::println);
			
			Criteria criteria3 = ses.createCriteria(Student.class);
			Criterion criterion3 = Restrictions.lt("age", 25);
			criteria3.add(criterion3);
			List<Student> students3 = criteria3.list();
			students3.forEach(System.out::println);
			
			Criteria criteria4 = ses.createCriteria(Student.class);
			Criterion criterion4 = Restrictions.le("age", 25);
			criteria4.add(criterion4);
			List<Student> students4 = criteria4.list();
			students4.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
