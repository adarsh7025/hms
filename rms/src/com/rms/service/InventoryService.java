package com.rms.service;

import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.contract.IInventoryDAO;
import com.rms.dao.InventoryDAO;
import com.rms.entity.Inventory;
import com.rms.formentity.InventoryForm;

/**
 * Service for invetory management
 * 
 * @author hegde_a
 *
 */
public class InventoryService {

	private final Logger logger = LoggerFactory.getLogger(InventoryService.class);

	public boolean addInventory(InventoryForm inventoryForm) {
		logger.info("Add inventory service");

		Inventory inventory = new Inventory(0, inventoryForm.getInventoryName(), inventoryForm.getCategory(),
				inventoryForm.getLocationId(), inventoryForm.getQuantity(), inventoryForm.getUnit());

		IInventoryDAO inventoryDAO = new InventoryDAO();
		return inventoryDAO.addInventory(inventory);
	}

	public JSONArray getAllInventoryItems(String term) {
		logger.info("Get inventory items using service");
		InventoryDAO inventoryDAO = new InventoryDAO();
		List<Inventory> inventories = inventoryDAO.getAllInventoryItems();
		JSONArray arrayObj = new JSONArray();
		term = term.toLowerCase();
		for (int i = 0; i < inventories.size(); i++) {
			String country = inventories.get(i).getInventoryName().toLowerCase();
			if (country.startsWith(term)) {
				arrayObj.put(inventories.get(i).getInventoryName());
			}
		}
		return arrayObj;

	}

	public InventoryForm getInventoryItem(String dishName) {
		logger.info("Service for retrieving single inventory record using dish name");
		InventoryDAO inventoryDAO = new InventoryDAO();
		Inventory inventory = inventoryDAO.getInventoryItem(dishName);
		InventoryForm inventoryForm = new InventoryForm(inventory.getInventoryId(), inventory.getInventoryName(),
				inventory.getCategory(), inventory.getLocationId(), inventory.getQuantity(), inventory.getUnit());
		return inventoryForm;

	}

	public boolean addInventoryQuantity(InventoryForm inventoryForm) {
		logger.info("Service for adding quantity to the inventory");
		IInventoryDAO inventoryDAO = new InventoryDAO();
		Inventory inventory = inventoryDAO.getInventoryItemFromId(inventoryForm.getInventoryId());
		inventory.setQuantity(inventoryForm.getQuantity() + inventory.getQuantity());
		boolean save = inventoryDAO.addInventoryQuantity(inventory);
		return save;

	}
}
