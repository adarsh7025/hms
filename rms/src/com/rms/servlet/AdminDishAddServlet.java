package com.rms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.dao.DishDAO;
import com.rms.dao.UserDAO;

/**
 * Servlet implementation class AdminDishAddServlet
 */
@WebServlet(name = "AdminDishAdd", urlPatterns = { "/AdminDishAdd" })
public class AdminDishAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(DishDAO.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDishAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRequest(request,response);
	}
	
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		logger.info("Admin Dish Add Servlet ");
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/adminDishAdd.jsp");
		dispatcher.forward(request, response);
		
	}  
	
	
	
}
