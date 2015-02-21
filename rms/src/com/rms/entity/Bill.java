package com.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BILL")
public class Bill {

	@Id
	@Column(name = "BILL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;

	@Column(name = "LOCATION_ID")
	private int locationId;

	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "DISH_ID")
	private int dishId;

	@Column(name = "QUANTITY")
	private double quantity;

	@Column(name = "COST")
	private double cost;

	@Column(name = "REFERENCE_ID")
	private int referenceId;

	@ManyToOne
	@JoinColumn(name = "BILL_STATEMENT_ID")
	private BillStatement billStatement;

	public Bill() {
		super();
	}

	public Bill(int billId, int locationId, int userId, int dishId, double quantity, double cost, int referenceId,
			BillStatement billStatement) {
		super();
		this.billId = billId;
		this.locationId = locationId;
		this.userId = userId;
		this.dishId = dishId;
		this.quantity = quantity;
		this.cost = cost;
		this.referenceId = referenceId;
		this.billStatement = billStatement;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}

	public BillStatement getBillStatement() {
		return billStatement;
	}

	public void setBillStatement(BillStatement billStatement) {
		this.billStatement = billStatement;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", locationId=" + locationId + ", userId=" + userId + ", dishId=" + dishId
				+ ", quantity=" + quantity + ", cost=" + cost + ", referenceId=" + referenceId + ", billStatement="
				+ billStatement + "]";
	}

}
