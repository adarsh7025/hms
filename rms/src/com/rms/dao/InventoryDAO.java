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

import com.rms.contract.IInventoryDAO;
import com.rms.entity.Inventory;

/**
 * DAO to handle the inventory
 * 
 * @author hegde_a
 *
 */
public class InventoryDAO implements IInventoryDAO {

	private final Logger logger = LoggerFactory.getLogger(InventoryDAO.class);

	@Override
	public boolean addInventory(Inventory inventory) {
		logger.info("Adding inventory to the database");

		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(inventory);

		} catch (HibernateException hibernateException) {

			logger.error("An " + hibernateException.getClass()
					+ " error occured while adding inventory to the database");
			hibernateException.printStackTrace();
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
	public List<Inventory> getAllInventoryItems() {
		logger.info("Getting all the inventory items from the database");
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		List<Inventory> inventories = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Inventory");
			inventories = query.list();

		} catch (HibernateException hibernateException) {

			logger.error("An " + hibernateException.getClass()
					+ " error occured while retrieving all inventory items from the database");
			hibernateException.printStackTrace();
			if (null != transaction) {
				transaction.rollback();
				return null;
			}
		} finally {
			transaction.commit();
			session.close();
		}
		return inventories;
	}

	@Override
	public Inventory getInventoryItem(String inventoryName) {
		logger.info("retrieve inventory record from the database using inventory name");
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		Inventory inventory = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Inventory where inventoryName=:name");
			query.setString("name", inventoryName);
			inventory = (Inventory) query.uniqueResult();

		} catch (HibernateException hibernateException) {

			logger.error("An " + hibernateException.getClass()
					+ " error occured while retrieving inventory item from the database using name");
			hibernateException.printStackTrace();
			if (null != transaction) {
				transaction.rollback();
				return null;
			}
		} finally {
			transaction.commit();
			session.close();
		}
		return inventory;
	}

	@Override
	public boolean addInventoryQuantity(Inventory inventory) {
		logger.info("add inventory to the database");
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(inventory);

		} catch (HibernateException hibernateException) {

			logger.error("An " + hibernateException.getClass()
					+ " error occured while adding inventory quantity to the database");
			hibernateException.printStackTrace();
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
	public Inventory getInventoryItemFromId(int id) {
		logger.info("retrieve inventory record from the database using id");
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		Inventory inventory = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Inventory where inventoryId=:id");
			query.setInteger("id", id);
			inventory = (Inventory) query.uniqueResult();

		} catch (HibernateException hibernateException) {

			logger.error("An " + hibernateException.getClass()
					+ " error occured while retrieving inventory item from the database using id");
			hibernateException.printStackTrace();
			if (null != transaction) {
				transaction.rollback();
				return null;
			}
		} finally {
			transaction.commit();
			session.close();
		}
		return inventory;
	
		
	}

}
