package com.rms.util;

import org.hibernate.SessionFactory;

public class TestHibernateSQLConnection {
	private static org.hibernate.cfg.Configuration myConfiguration;
	private static SessionFactory sessionFactory;

	static {
		myConfiguration = new org.hibernate.cfg.Configuration().configure();
		sessionFactory = myConfiguration.buildSessionFactory();
		System.out.println("My configuration "+ myConfiguration);

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		System.out.println(getSessionFactory());
	}

}
