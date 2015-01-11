package com.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DISH")
public class Dish {

	@Id
	@Column(name = "DISH_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dishId;

	@Column(name = "DISH_NAME")
	private String dishName;

	@Column(name = "QUANTITY")
	private double quantity;

	@Column(name = "LOCATION_ID")
	private int locationId;

	@Column(name = "PRICE")
	private double price;

	public Dish() {
		super();
	}

	public Dish(int dishId, String dishName, double quantity, int locationId, double price) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.quantity = quantity;
		this.locationId = locationId;
		this.price = price;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Dish [dishId=" + dishId + ", dishName=" + dishName + ", quantity=" + quantity + ", locationId="
				+ locationId + ", price=" + price + "]";
	}

}
