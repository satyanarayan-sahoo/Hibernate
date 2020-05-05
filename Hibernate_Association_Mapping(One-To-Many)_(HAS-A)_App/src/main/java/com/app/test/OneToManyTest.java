package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Module;
import com.app.model.Product;
import com.app.util.HibernateUtil;

/* Here One Product has so many Modules */

public class OneToManyTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSf();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		Module mod1=new Module();
		mod1.setModuleId(301);
		mod1.setModuleName("Lumin");
		mod1.setModuleType("Vernability Check");
		
		Module mod2=new Module();
		mod2.setModuleId(302);
		mod2.setModuleName("WAS");
		mod2.setModuleType("Scanning");
		
		Product pro=new Product();
		pro.setProductId(7777);
		pro.setProductName("Tenable io");
		pro.setProductCost(564753458);
		pro.getMod().add(mod1);
		pro.getMod().add(mod2);
		
		ses.save(pro);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
