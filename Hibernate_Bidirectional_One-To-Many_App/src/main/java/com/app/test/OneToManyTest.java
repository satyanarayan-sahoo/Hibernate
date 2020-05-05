package com.app.test;

import java.util.HashSet;
import java.util.Set;

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
		
		Product pro=new Product();
		pro.setProductId(7777);
		pro.setProductName("Tenable io");
		pro.setProductCost(564753458);
		
		Module mod1=new Module();
		mod1.setModuleId(301);
		mod1.setModuleName("Lumin");
		mod1.setModuleType("Vernability Check");
		mod1.setProd(pro);
		
		Module mod2=new Module();
		mod2.setModuleId(302);
		mod2.setModuleName("WAS");
		mod2.setModuleType("Scanning");
		mod2.setProd(pro);
		
		Set<Module> modules = new HashSet<Module>();
		modules.add(mod1);
		modules.add(mod2);
		
		pro.setMod(modules);
		
		ses.save(pro);
		
		tx.commit();
		ses.close();
		sf.close();
	}//main

}//class
