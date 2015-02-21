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

import com.rms.contract.IBillingDAO;
import com.rms.entity.Bill;
import com.rms.entity.BillStatement;

/**
 * 
 * @author hegde_a DAO to make Bill transactions
 *
 */
public class BillingDAO implements IBillingDAO {

	private final Logger logger = LoggerFactory.getLogger(BillingDAO.class);

	/**
	 * saves a list of bills to bill and bill_statement
	 */
	@Override
	public boolean saveBill(List<Bill> bills, BillStatement billStatement) {
		logger.info("Generating a bill");
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(billStatement);
			for (Bill bill : bills) {
				bill.setBillStatement(billStatement);
				session.saveOrUpdate(bill);
			}

		} catch (HibernateException hibernateException) {
			logger.error("Error during generation of bill");
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
	public List<BillStatement> getBillStatementFromLocationId(int locationId) {
		logger.info("Retrieving Bill Statement for a location");
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		List<BillStatement> billStatements = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM BillStatement WHERE locationId=:id");
			query.setInteger("id", locationId);
			billStatements = query.list();
		} catch (HibernateException hibernateException) {
			logger.error("Error during retrieving bill statement from location");
			if (null != transaction) {
				transaction.rollback();
				throw hibernateException;
			}
		} finally {
			transaction.commit();
			session.close();
		}
		return billStatements;
	}

	@Override
	public List<Bill> getBillFromBillStatementId(int billStatementId) {
		logger.info("Retriving all the bills belonging to a bill statement");
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		List<Bill> bills = null;
		try {
			transaction = session.beginTransaction();
			BillStatement billStatement = getBillStatementFromId(billStatementId);
			Query query = session.createQuery("FROM Bill WHERE billStatement=:billStatement");
			query.setParameter("billStatement", billStatement);
			bills = query.list();
		} catch (HibernateException hibernateException) {
			logger.error("Error while retrieving bills from bill statement");
			if (null != transaction) {
				transaction.rollback();
				return null;
			}
		} finally {
			transaction.commit();
			session.close();
		}
		return bills;
	}

	@Override
	public BillStatement getBillStatementFromId(int billStatementId) {
		logger.info("Retrieving the bill statement record from id");
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		BillStatement billStatement = null;
		try {
			transaction = session.beginTransaction();
			billStatement = (BillStatement) session.get(BillStatement.class, billStatementId);
		} catch (HibernateException hibernateException) {
			logger.error("The bill statement could not be retrieved");
			if (null != transaction) {
				transaction.rollback();
				return null;
			}
		} finally {
			transaction.commit();
			session.close();
		}

		return billStatement;
	}

}
