package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.model.Module;
import com.app.model.Product;
import com.app.util.HibernateUtil;

public class OneToMany_BidirectionalTest {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			String hql1 = "from com.app.model.Product";
			Query query1 = ses.createQuery(hql1);
			List<Product> products = query1.list();
			for (Product p:products) {
				System.out.println("Product is: "+p+"--->Modules are: "+p.getMod());
			}
			
			System.out.println("---------------------------------------------------");
			
			String hql2 = "from com.app.model.Module";
			Query query2 = ses.createQuery(hql2);
			List<Module> modules = query2.list();
			for (Module mod:modules) {
				System.out.println("Module is: "+mod+"--->Product is: "+mod.getProd());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
