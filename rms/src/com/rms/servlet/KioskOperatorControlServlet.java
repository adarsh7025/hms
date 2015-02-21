package com.rms.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.dao.BillingDAO;
import com.rms.formentity.BillForm;
import com.rms.formentity.BillStatementForm;
import com.rms.formentity.DishForm;
import com.rms.service.BillingService;
import com.rms.service.DishService;
import com.rms.service.LocationService;

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
		HttpSession httpSession = request.getSession();
		int userLocationId = (Integer) httpSession.getAttribute("locationId");
		String action = ((String) request.getAttribute("action") != null) ? (String) request.getAttribute("action")
				: (String) request.getParameter("action");
		RequestDispatcher dispatcher = null;

		switch (action) {

		case "billing":
			logger.info("Kiosk Operator being routed to billing page");
			dispatcher = request.getRequestDispatcher("jsp/kioskOperator.jsp");
			DishService dishService = new DishService();
			List<DishForm> dishForms = dishService.getDish();
			LocationService locationService = new LocationService();
			double tax = locationService.getTaxForLocation(userLocationId);

			request.setAttribute("dishes", dishForms);
			request.setAttribute("tax", tax);
			logger.info("Sending dish information to kiosk operator");
			dispatcher.forward(request, response);
			break;

		case "addBill":
			List<BillForm> bills = addBill(request, userLocationId);
			BillStatementForm billStatementForm = addBillStatement(request, userLocationId);
			BillingService billingService = new BillingService();
			boolean saveBill = billingService.addBill(bills, billStatementForm);
			request.setAttribute("action", "billing");
			request.setAttribute("billSaveStatus", saveBill);
			dispatcher = request.getRequestDispatcher("KioskOperatorControl");
			dispatcher.forward(request, response);
			break;

		}
	}

	private BillStatementForm addBillStatement(HttpServletRequest request, int userLocationId) {
		logger.info("Bill statement added by kiosk operator");
		long lDateTime = new Date().getTime();

		BillStatementForm billStatementForm = new BillStatementForm(0,
				Double.parseDouble(request.getParameter("total")),
				Double.parseDouble(request.getParameter("totalBill")), Double.parseDouble(request
						.getParameter("taxAmount")), new Timestamp(lDateTime), userLocationId, null);
		return billStatementForm;
	}

	public List<BillForm> addBill(HttpServletRequest request, int locationId) {
		logger.info("Bills added by kiosk operator");

		HttpSession session = request.getSession();
		List<BillForm> bills = new ArrayList<BillForm>();
		String id = (String) request.getParameter("dishId");
		String price = (String) request.getParameter("price");
		String quantity = (String) request.getParameter("quantity");
		String[] dishIds = id.split(",");
		String[] dishPrices = price.split(",");
		String[] dishQuantities = quantity.split(",");
		int userId = (Integer) session.getAttribute("userId");

		for (int i = 0; i < dishIds.length; i++) {
			bills.add(new BillForm(0, locationId, userId, Integer.parseInt(dishIds[i]), Double
					.parseDouble(dishQuantities[i]), Double.parseDouble(dishPrices[i]), 0, null));
		}
		return bills;

	}
}
