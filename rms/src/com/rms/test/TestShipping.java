package com.rms.test;

import static com.rms.util.TestHibernateSQLConnection.getSessionFactory;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rms.entity.Shipping;

public class TestShipping {
	public static void main(String[] args) {
		
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		long lDateTime = new Date().getTime();
		Shipping shipping = new Shipping(100, 1, 1, 1, new Timestamp(lDateTime), new Timestamp(lDateTime), 122d);
		session.save(shipping);
		transaction.commit();
		session.close();
		
	}

}
