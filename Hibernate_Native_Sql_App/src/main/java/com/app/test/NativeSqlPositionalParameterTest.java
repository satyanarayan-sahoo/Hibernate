package com.app.test;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

/* Native Query supports positional Parameters on SQL, index number starts from one(1) [1,2,3,...] */

public class NativeSqlPositionalParameterTest {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			String sql = "select * from employee_nativesql_tab where eid=?";
			NativeQuery q = ses.createNativeQuery(sql);
			q.setParameter(1, 101);
			q.addEntity(Employee.class);
			Employee e = (Employee) q.uniqueResult();
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
