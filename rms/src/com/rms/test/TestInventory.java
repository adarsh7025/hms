package com.rms.test;

import java.util.List;

import com.rms.contract.IInventoryDAO;
import com.rms.dao.InventoryDAO;
import com.rms.entity.Inventory;
import com.rms.service.InventoryService;

public class TestInventory {

	public static void main(String[] args) {

		Inventory inventory = new Inventory(0, "Wheat", "Food", 1, 13.2d, "kg");

		IInventoryDAO iInventoryDAO = new InventoryDAO();
		System.out.println(iInventoryDAO.getInventoryItemFromId(1));
		//System.out.println(iInventoryDAO.getInventoryItem("Water"));
		
		// iInventoryDAO.addInventory(inventory);
		/*List<Inventory> inventories = iInventoryDAO.getAllInventoryItems();
		for (Inventory inventory2 : inventories) {
			System.out.println(inventory2);
		}*/
		/*InventoryService inventoryService = new InventoryService();
		System.out.println(inventoryService.getInventoryItem("Water"));*/
	}
}
