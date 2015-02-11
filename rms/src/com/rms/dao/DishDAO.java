package com.rms.dao;

import static com.rms.util.TestHibernateSQLConnection.getSessionFactory;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.contract.IDishDAO;
import com.rms.entity.Dish;




 public class DishDAO implements IDishDAO {
	 
	 private final Logger logger = LoggerFactory.getLogger(DishDAO.class);
	 
	
	 public List<Dish> getDish()
	 {
		//logger.info("Retrieving Dish from database");
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		List<Dish> dish = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Dish");
			dish = query.list();
		} catch (HibernateException hibernateException) {
			logger.error("Error during retrieving Dish");
			if (null != transaction) {
				transaction.rollback();
				throw hibernateException;
			}
		} finally {
			transaction.commit();
			session.close();
		}
		return dish;
	}
	 
	 
}
