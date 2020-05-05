package com.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*Class is used to create one object to SessionFactory(I) using singleton design pattern with eager loading (Static block)
  -Sessionfactory is a heavy weight (consumes more memory) object
  -Sf, loads driver class, creates connection, handles statement and also hibernate properties management
   (dialect,show_sql,format_sql,hbm2ddl.auto)*/

public class HibernateUtil {
	private static SessionFactory sf;
	
	static {
		sf=new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSf() {
		return sf;
	}
	
}//class
