package com.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.dao.BillingDAO;
import com.rms.entity.Bill;
import com.rms.entity.BillStatement;
import com.rms.formentity.BillForm;
import com.rms.formentity.BillStatementForm;

/**
 * Service class for Billing operations
 * 
 * @author hegde_a
 *
 */
public class BillingService {

	private final Logger logger = LoggerFactory.getLogger(BillingService.class);

	public boolean addBill(List<BillForm> billForms, BillStatementForm billStatementForm) {
		logger.info("billing service add bill");
		List<Bill> bills = new ArrayList<Bill>();
		
		for (BillForm billForm : billForms) {
			bills.add(new Bill(0, billForm.getLocationId(), billForm.getUserId(), billForm.getDishId(), billForm
					.getQuantity(), billForm.getCost(), 0, null));
		}

		BillStatement billStatement = new BillStatement(0, billStatementForm.getBillAmount(),
				billStatementForm.getTotalAmount(), billStatementForm.getTaxAmount(), billStatementForm.getBillDate(),
				billStatementForm.getLocationId(), bills);

		BillingDAO billingDAO = new BillingDAO();
		boolean save = billingDAO.saveBill(bills, billStatement);
		if (save)
			return true;
		else
			return false;

	}
}
