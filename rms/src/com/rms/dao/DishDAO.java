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
import com.rms.entity.User;




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
	 
	 public boolean addDish(Dish dish,double count) {
			logger.info("Adding a Dish to the database");

			SessionFactory factory = getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = null;
             System.out.println(count);
			try {
				
				transaction = session.beginTransaction();
				
				session.save(dish);
			} catch (HibernateException hibernateException) {
				logger.info("Error while adding dish to database");
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
	 
}
