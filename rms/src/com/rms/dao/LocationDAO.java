package com.rms.dao;

import static com.rms.util.TestHibernateSQLConnection.getSessionFactory;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.contract.ILocationDAO;
import com.rms.entity.Location;

/**
 * DAO for the location table
 * 
 * @author hegde_a
 *
 */
public class LocationDAO implements ILocationDAO {

	private final Logger logger = LoggerFactory.getLogger(LocationDAO.class);

	@Override
	public double getTaxForLocation(int locationId) {
		logger.info("Retrieving tax amount for the location from database");

		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		Location location = null;
		try {
			transaction = session.beginTransaction(); 
			Query query = session.createQuery("FROM Location WHERE locationId=:id");
			query.setInteger("id", locationId);
			location = (Location) query.uniqueResult();

		} catch (HibernateException hibernateException) {
			logger.info("Error while retrieving tax value from database");
			if (null != transaction) {
				transaction.rollback();
				return 0;
			}
		} finally {
			transaction.commit();
			session.close();
		}
		return location.getTax();
	}

}
