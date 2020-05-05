package com.app.gen;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		//String date=new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		int number=new Random().nextInt(1000);
		
		//String prifix1="SIT";
		//String prifix2="HIB";
		return number;
	}//main

}//class
