package com.rms.test;
import static com.rms.util.TestHibernateSQLConnection.getSessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rms.entity.User;

public class TestUser {
	public static void main(String[] args) {
		
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User(100, "adarsh@25", "adarsh123", "adarsh", "operator", 1, 101, 9029143439l, 'Y');
		
		User user2 = (User) session.load(User.class, 1);
		//System.out.println("User>>>"+user2);
		//session.save(user);
		List<User> users = session.createQuery("from User").list();
		System.out.println("Users>>>"+users);
		transaction.commit();
		session.close();
		
	}

}
