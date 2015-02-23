package com.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.contract.IDishDAO;
import com.rms.contract.ILocationDAO;
import com.rms.contract.IUserDAO;
import com.rms.dao.DishDAO;
import com.rms.dao.LocationDAO;
import com.rms.dao.UserDAO;
import com.rms.entity.Dish;
import com.rms.entity.User;
import com.rms.formentity.DishForm;
import com.rms.formentity.UserForm;


public class AdminService {

	private final Logger logger = LoggerFactory.getLogger(UserDAO.class);

	public boolean addUser(UserForm user2) {
		
		logger.info("Add User");
		System.out.println(user2.getId());
		User user = new User();
		user.setId(user2.getId());
		user.setPassword(user2.getPassword());
		user.setUserId(user2.getUserId());
		user.setName(user2.getName());
		user.setParent(user2.getParent());
		user.setPhoneNo(user2.getPhoneNo());
		user.setActive('Y');
		user.setLocationId(user2.getLocationId());
		user.setType(user2.getType());
		IUserDAO userDAO = new UserDAO();
		boolean user3 = userDAO.addUser(user);
		
		return user3;
		
	}
	
	public boolean addDish(DishForm dish2) {
		
		logger.info("AddDish in adminService");
		System.out.println(dish2.getDishId());
		Dish dish=new Dish();
		dish.setDishName(dish2.getDishName());
		dish.setLocationId(dish2.getLocationId());
		dish.setPrice(dish2.getPrice());
		dish.setQuantity(dish2.getQuantity());
		
		double count=0;
		
		ILocationDAO locationDAO=new LocationDAO();
		count=locationDAO.getLocationCount();
		IDishDAO dishdao=new DishDAO();
		boolean dish3 = dishdao.addDish(dish,count);
		
		return dish3;
		
	}
	
	
	
}