package com.rms.formentity;

public class InventoryForm {

	private int inventoryId;
	private String inventoryName;
	private String category;
	private int locationId;
	private double quantity;
	private String unit;

	public InventoryForm() {
		super();
	}

	public InventoryForm(int inventoryId, String inventoryName, String category, int locationId, double quantity,
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
		return "InventoryForm [inventoryId=" + inventoryId + ", inventoryName=" + inventoryName + ", category="
				+ category + ", locationId=" + locationId + ", quantity=" + quantity + ", unit=" + unit + "]";
	}

}
