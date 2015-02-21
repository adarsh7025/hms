package com.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

	@Id
	@Column(name = "INVENTORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryId;

	@Column(name = "INVENTORY_NAME")
	private String inventoryName;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "LOCATION_ID")
	private int locationId;

	@Column(name = "QUANTITY")
	private double quantity;

	@Column(name = "UNIT")
	private String unit;

	public Inventory() {
		super();
	}

	public Inventory(int inventoryId, String inventoryName, String category, int locationId, double quantity,
			String unit) {
		super();
		this.inventoryId = inventoryId;
		this.inventoryName = inventoryName;
		this.category = category;
		this.locationId = locationId;
		this.quantity = quantity;
		this.unit = unit;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", inventoryName=" + inventoryName + ", category=" + category
				+ ", locationId=" + locationId + ", quantity=" + quantity + ", unit=" + unit + "]";
	}

}
