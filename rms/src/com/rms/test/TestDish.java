package com.rms.test;

import static com.rms.util.TestHibernateSQLConnection.getSessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rms.contract.IDishDAO;
import com.rms.dao.DishDAO;
import com.rms.entity.Dish;

public class TestDish {
	public static void main(String[] args) {
		
		/*SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Dish dish = new Dish(400, "Vada Sambhar", 10d, 1, 25.25);
		session.save(dish);
		
		transaction.commit();
		session.close();*/
		IDishDAO dishDAO = new DishDAO();
		List<Dish> dishs = dishDAO.getDish();
		for (Dish dish : dishs) {
			System.out.println(dish);
		}
	}

}
