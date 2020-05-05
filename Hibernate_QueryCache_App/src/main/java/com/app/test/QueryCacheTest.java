package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.model.Student;

/*In query Cache you need to set query manually as cacheable for result caching of a particular query.Here once the query is executed,if we trying to execute 
  the same query with the same parameter then the query results are retrieved from the query cache instead of load the entity from the database . 
  * It is totally dependent form the SessionFactory Cache.
  * If we clear or evict the current session then also we can load from the query cache*/

public class QueryCacheTest {

	public static void main(String[] args) {
		SessionFactory sf1=new Configuration().configure().buildSessionFactory();
		
		Session ses=sf1.openSession();
		
		Student s1=(Student) ses.createQuery("from com.app.model.Student where stdId= :id").setParameter("id",101).setCacheable(true).setCacheRegion("studentcache").uniqueResult();
		System.out.println(s1);
		
		ses.evict(s1);
		System.out.println("Second time it loaded from the Query Cache");
		s1=(Student) ses.createQuery("from com.app.model.Student where stdId= :id").setParameter("id",101).setCacheable(true).setCacheRegion("studentcache").uniqueResult();
		System.out.println(s1);
		
		ses.clear();
		System.out.println("Second time it loaded from the Query Cache");
		s1=(Student) ses.createQuery("from com.app.model.Student where stdId= :id").setParameter("id",101).setCacheable(true).setCacheRegion("studentcache").uniqueResult();
		System.out.println(s1);
		
		ses.close();
		sf1.close();
		
		SessionFactory sf2=new Configuration().configure().buildSessionFactory();
		Session ses2=sf2.openSession();
		Student s2=(Student) ses2.createQuery("from com.app.model.Student where stdId= :id").setParameter("id",101).setCacheable(true).setCacheRegion("studentcache").uniqueResult();
		System.out.println(s2);
		
		ses2.close();
		sf2.close();
	}//main

}//class
