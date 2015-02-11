package com.rms.formentity;


public class DishForm {

	private int dishId;
	private String dishName;
	private double quantity;
	private int locationId;
	private double price;

	public DishForm() {
		super();
	}

	public DishForm(int dishId, String dishName, double quantity, int locationId, double price) {
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
		return "DishForm [dishId=" + dishId + ", dishName=" + dishName + ", quantity=" + quantity + ", locationId="
				+ locationId + ", price=" + price + "]";
	}

}
