package com.rms.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SHIPPING")
public class Shipping {

	@Id
	@Column(name = "SHIPMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shipmentId;

	@Column(name = "INVENTORY_ID")
	private int inventoryId;

	@Column(name = "FROM_LOCATION_ID")
	private int fromLocationId;

	@Column(name = "TO_LOCATION_ID")
	private int toLocationId;

	@Column(name = "FROM_DATE")
	private Timestamp fromDate;

	@Column(name = "TO_DATE")
	private Timestamp toDate;

	@Column(name = "QUANTITY")
	private double quantity;

	public Shipping() {
		super();
	}

	public Shipping(int shipmentId, int inventoryId, int fromLocationId, int toLocationId, Timestamp fromDate,
			Timestamp toDate, double quantity) {
		super();
		this.shipmentId = shipmentId;
		this.inventoryId = inventoryId;
		this.fromLocationId = fromLocationId;
		this.toLocationId = toLocationId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.quantity = quantity;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getFromLocationId() {
		return fromLocationId;
	}

	public void setFromLocationId(int fromLocationId) {
		this.fromLocationId = fromLocationId;
	}

	public int getToLocationId() {
		return toLocationId;
	}

	public void setToLocationId(int toLocationId) {
		this.toLocationId = toLocationId;
	}

	public Timestamp getFromDate() {
		return fromDate;
	}

	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getToDate() {
		return toDate;
	}

	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Shipping [shipmentId=" + shipmentId + ", inventoryId=" + inventoryId + ", fromLocationId="
				+ fromLocationId + ", toLocationId=" + toLocationId + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", quantity=" + quantity + "]";
	}

}
