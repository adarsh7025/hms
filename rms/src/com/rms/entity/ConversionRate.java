package com.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONVERSION_RATE")
public class ConversionRate {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "DISH_ID")
	private int dishId;

	@Column(name = "INVENTORY_ID")
	private int inventoryId;

	@Column(name = "INVENTORY_QTY")
	private double inventoryQuantity;

	public ConversionRate() {
		super();
	}

	public ConversionRate(int id, int dishId, int inventoryId, double inventoryQuantity) {
		super();
		this.id = id;
		this.dishId = dishId;
		this.inventoryId = inventoryId;
		this.inventoryQuantity = inventoryQuantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public double getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(double inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	@Override
	public String toString() {
		return "ConversionRate [id=" + id + ", dishId=" + dishId + ", inventoryId=" + inventoryId
				+ ", inventoryQuantity=" + inventoryQuantity + "]";
	}

}
