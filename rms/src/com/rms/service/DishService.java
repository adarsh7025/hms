package com.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.contract.IDishDAO;
import com.rms.dao.DishDAO;
import com.rms.dao.UserDAO;
import com.rms.entity.Dish;
import com.rms.formentity.DishForm;

public class DishService {

	private final Logger logger = LoggerFactory.getLogger(UserDAO.class);

	public List<DishForm> getDish() {
		
		logger.info("Retrieve dish service");
		IDishDAO dishDAO = new DishDAO();
		List<Dish> dishes = dishDAO.getDish();
		List<DishForm> dishForms = new ArrayList<DishForm>();
		DishForm dishForm = new DishForm();
		for (Dish dish : dishes) {
			dishForm = new DishForm(dish.getDishId(), dish.getDishName(), dish.getQuantity(), dish.getLocationId(),
					dish.getPrice());
			dishForms.add(dishForm);

		}
		return dishForms;
	}
}