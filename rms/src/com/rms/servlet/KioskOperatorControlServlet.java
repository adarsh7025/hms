package com.rms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.dao.BillingDAO;
import com.rms.formentity.DishForm;
import com.rms.service.DishService;

/**
 * Servlet implementation class KioskOperatorControlServlet is the controller
 * for the kioskoperator operations
 * 
 * @author hegde_a
 */
@WebServlet("/KioskOperatorControl")
public class KioskOperatorControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(BillingDAO.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KioskOperatorControlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doRequest(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		logger.info("Kiosk operator control servlet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/kioskOperator.jsp");
		DishService dishService = new DishService();
		List<DishForm> dishForms = dishService.getDish();
		for (DishForm dishForm : dishForms) {
			System.out.println(dishForm);
		}
		request.setAttribute("dishes", dishForms);
		logger.info("Sending dish information to kiosk operator");
		dispatcher.forward(request, response);
		//response.sendRedirect("jsp/kioskOperator.jsp");

	}

}
