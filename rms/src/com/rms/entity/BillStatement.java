/*
 create table BILL_STATEMENT(
	BILL_STATEMENT_ID int primary key auto_increment,
	BILL_ID int,
	BILL_AMOUNT double(10,2),
	TOTAL_AMOUNT double(10,2),
	TAX_AMOUNT double(10,2),
	BILL_DATE datetime,
	FOREIGN KEY(BILL_ID) references BILL(BILL_ID)
);

*/
package com.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "BILL_STATEMENT")
public class BillStatement {
	
	@Id
	@Column(name="BILL_STATEMENT_ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int billStatementId;
	
	@Column(name = "BILL_ID")
	private int billId;
	
	@Column(name = "BILL_AMOUNT")
	private double billAmount;
	
	@Column(name = "TOTAL_AMOUNT")
	private double totalAmount;
	
	@Column(name = "TAX_AMOUNT")
	private double taxAmount;
	
	@Column(name = "BILL_DATE")
	private Timestamp billDate;

	public BillStatement() {
		super();
	}

	public BillStatement(int billStatementId, int billId, double billAmount, double totalAmount, double taxAmount,
			Timestamp billDate) {
		super();
		this.billStatementId = billStatementId;
		this.billId = billId;
		this.billAmount = billAmount;
		this.totalAmount = totalAmount;
		this.taxAmount = taxAmount;
		this.billDate = billDate;
	}

	public int getBillStatementId() {
		return billStatementId;
	}

	public void setBillStatementId(int billStatementId) {
		this.billStatementId = billStatementId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
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

	@Override
	public String toString() {
		return "BillStatement [billStatementId=" + billStatementId + ", billId=" + billId + ", billAmount="
				+ billAmount + ", totalAmount=" + totalAmount + ", taxAmount=" + taxAmount + ", billDate=" + billDate
				+ "]";
	}


	
	
	
	
	
}