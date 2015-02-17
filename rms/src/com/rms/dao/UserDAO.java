package com.rms.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.contract.IUserDAO;
import com.rms.entity.User;

import static com.rms.util.TestHibernateSQLConnection.getSessionFactory;

/**
 * DAO to make transactions for User
 * 
 * @author hegde_a
 *
 */
public class UserDAO implements IUserDAO {

	private final Logger logger = LoggerFactory.getLogger(UserDAO.class);

	@Override
	public boolean addUser(User user) {
		logger.info("Adding a user to the database");
          System.out.println(user.getId()+" "+user.getActive()+" "+user.getLocationId()+user.getName()+user.getParent());
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(user);
		} catch (HibernateException hibernateException) {
			logger.info("Error while adding user to database");
			if (null != transaction) {
				transaction.rollback();
				return false;
			}
		} finally {
			transaction.commit();
			session.close();
		}
		return true;
	}

	@Override
	public User authenticateUser(User user) {

		logger.info("Authenticating user");

		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		String userId = user.getUserId();
		String password = user.getPassword();
		User user2 = null;

		try {
			transaction = session.beginTransaction();
			
			Query query = session.createQuery("FROM User WHERE userId=:userIdString and password=:passwordString"); 
			query.setString("userIdString", userId);
			query.setString("passwordString", password);
			 user2 = (User) query.uniqueResult();
			 
			if (null == user2) {
				logger.info("Invalid user login");
				return null;
			}
		} catch (HibernateException hibernateException) {
			logger.info("Error on login");
			if (null != transaction) {
				transaction.rollback();
				return null;
			}
		} finally {
			transaction.commit();
			session.close();
		}
		return user2;

	}

}
