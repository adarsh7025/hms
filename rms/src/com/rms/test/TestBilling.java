package com.rms.test;

import static com.rms.util.TestHibernateSQLConnection.getSessionFactory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rms.dao.BillingDAO;
import com.rms.entity.Bill;
import com.rms.entity.BillStatement;

public class TestBilling {
	public static void main(String[] args) {
		// SessionFactory factory = getSessionFactory();
		// Session session = factory.openSession();
		// Transaction transaction = session.beginTransaction();
		/*
		 * BillStatement billStatement = new BillStatement();
		 * 
		 * billStatement.setBillAmount(1000d); long lDateTime = new
		 * Date().getTime(); billStatement.setBillDate(new
		 * Timestamp(lDateTime)); billStatement.setTaxAmount(200d);
		 * billStatement.setTotalAmount(3000d); billStatement.setLocationId(1);
		 * 
		 * List<Bill> bills = new ArrayList<Bill>(); //
		 * session.save(billStatement); bills.add(new Bill(1, 1, 1, 2, 10d, 12d,
		 * 0, billStatement)); bills.add(new Bill(2, 1, 1, 2, 1d, 25d, 0,
		 * billStatement));
		 */
		BillingDAO billingDAO = new BillingDAO();

		/*
		 * List<BillStatement> billStatements =
		 * billingDAO.getBillStatementFromLocationId(1); for (BillStatement
		 * statement : billStatements) { // System.out.println(statement); }
		 */

		List<Bill> bills = billingDAO.getBillFromBillStatementId(2);
		for (Bill bill : bills) {
			System.out.println(bill);
		}
		// BillStatement billStatement = billingDAO.getBillStatementFromId(3);
		// System.out.println(billStatement);
		// // session.save(bill);
		// session.save(bill2);

		// transaction.commit();
		// session.close();
	}

}
