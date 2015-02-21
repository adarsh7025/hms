package com.rms.formentity;


/**
 * 
 * @author hegde_a
 *
 */
public class BillForm {

	private int billId;
	private int locationId;
	private int userId;
	private int dishId;
	private double quantity;
	private double cost;
	private int referenceId;
	private BillStatementForm billStatement;

	public BillForm() {
		super();
	}

	public BillForm(int billId, int locationId, int userId, int dishId, double quantity, double cost, int referenceId,
			BillStatementForm billStatement) {
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

	public BillStatementForm getBillStatement() {
		return billStatement;
	}

	public void setBillStatement(BillStatementForm billStatement) {
		this.billStatement = billStatement;
	}

	@Override
	public String toString() {
		return "BillForm [billId=" + billId + ", locationId=" + locationId + ", userId=" + userId + ", dishId="
				+ dishId + ", quantity=" + quantity + ", cost=" + cost + ", referenceId=" + referenceId
				+ ", billStatement=" + billStatement + "]";
	}

}
