package com.rms.contract;

import java.util.List;

import com.rms.entity.Bill;
import com.rms.entity.BillStatement;

public interface IBillingDAO {

	/**
	 * saves the bill and bill_statement to the db
	 * 
	 * @param bills
	 * @param billStatement
	 * @return
	 */
	public boolean saveBill(List<Bill> bills, BillStatement billStatement);

	/**
	 * gets all the bill statements for a particular location
	 * 
	 * @param locationId
	 * @return
	 */
	public List<BillStatement> getBillStatementFromLocationId(int locationId);

	/**
	 * lists the bills for a bill statement
	 * 
	 * @param billStatementId
	 * @return
	 */
	public List<Bill> getBillFromBillStatementId(int billStatementId);

	/**
	 * gets the bill statement record for the particular id
	 * 
	 * @param billStatement
	 * @return
	 */
	public BillStatement getBillStatementFromId(int billStatementId);

}
