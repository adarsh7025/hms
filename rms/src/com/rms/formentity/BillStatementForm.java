package com.rms.formentity;

import java.sql.Timestamp;
import java.util.List;

/**
 * 
 * @author hegde_a
 *
 */
public class BillStatementForm {
	private int billStatementId;
	private double billAmount;
	private double totalAmount;
	private double taxAmount;
	private Timestamp billDate;
	private int locationId;
	private List<BillForm> bills;

	public BillStatementForm() {
		super();
	}

	public BillStatementForm(int billStatementId, double billAmount, double totalAmount, double taxAmount,
			Timestamp billDate, int locationId, List<BillForm> bills) {
		super();
		this.billStatementId = billStatementId;
		this.billAmount = billAmount;
		this.totalAmount = totalAmount;
		this.taxAmount = taxAmount;
		this.billDate = billDate;
		this.locationId = locationId;
		this.bills = bills;
	}

	public int getBillStatementId() {
		return billStatementId;
	}

	public void setBillStatementId(int billStatementId) {
		this.billStatementId = billStatementId;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Timestamp getBillDate() {
		return billDate;
	}

	public void setBillDate(Timestamp billDate) {
		this.billDate = billDate;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public List<BillForm> getBills() {
		return bills;
	}

	public void setBills(List<BillForm> bills) {
		this.bills = bills;
	}

	@Override
	public String toString() {
		return "BillStatementForm [billStatementId=" + billStatementId + ", billAmount=" + billAmount
				+ ", totalAmount=" + totalAmount + ", taxAmount=" + taxAmount + ", billDate=" + billDate
				+ ", locationId=" + locationId + ", bills=" + bills + "]";
	}

}
