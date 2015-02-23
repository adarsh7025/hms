package com.rms.contract;

import java.util.List;

import com.rms.entity.BillStatement;
import com.rms.entity.Dish;
import com.rms.entity.User;

public interface IDishDAO {

	
	public List<Dish> getDish();
	
	public boolean addDish(Dish dish,double count);
}
