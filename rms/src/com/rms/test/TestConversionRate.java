package com.rms.test;

import static com.rms.util.TestHibernateSQLConnection.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rms.entity.ConversionRate;

public class TestConversionRate {
	public static void main(String[] args) {
		
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		ConversionRate conversionRate = new ConversionRate(100, 100, 2, 144d);

		session.save(conversionRate);

		transaction.commit();
		session.close();
	}

}
