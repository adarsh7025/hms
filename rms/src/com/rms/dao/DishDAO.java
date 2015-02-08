package com.rms.dao;

import static com.rms.util.TestHibernateSQLConnection.getSessionFactory;




import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.contract.IDishDAO;
import com.rms.entity.Bill;
import com.rms.entity.BillStatement;
import com.rms.entity.Dish;




 class DishDAO implements IDishDAO {
	 
	 private final Logger logger = LoggerFactory.getLogger(BillingDAO.class);
	 
	
	 public List<Dish> getDish()
	 {
		logger.info("Retrieving Dish");
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		List<Dish> dish = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Dish");
			//query.setInteger();
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
