package com.rms.contract;

import java.util.List;

import com.rms.entity.Inventory;

public interface IInventoryDAO {

	public boolean addInventory(Inventory inventory);

	public List<Inventory> getAllInventoryItems();

	public Inventory getInventoryItem(String inventoryName);

	public boolean addInventoryQuantity(Inventory inventory);
	
	public Inventory getInventoryItemFromId(int id);
}
