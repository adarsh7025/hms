package com.rms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.formentity.InventoryForm;
import com.rms.service.InventoryService;

/**
 * @author hegde_a Servlet implementation class ManagerServlet
 */
@WebServlet("/Manager")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(ManagerServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doRequest(request, response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		try {
			doRequest(request, response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @throws JSONException
	 * @see HttpServlet#doRequest(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException, JSONException {
		logger.info("Manager Servlet has control");
		RequestDispatcher dispatcher = null;
		String action = ((String) request.getAttribute("action") != null) ? (String) request.getAttribute("action")
				: (String) request.getParameter("action");

		switch (action) {
		case "inventory":
			logger.info("forwarding request to addInventory.jsp");
			dispatcher = request.getRequestDispatcher("jsp/addInventory.jsp");
			dispatcher.forward(request, response);
			break;
		case "getData":
			logger.info("getting data for the autocomplete");
			printData(request, response);
			break;
		case "getItem":
			logger.info("getting a single inventory record using dishName");
			printInventoryItem(request, response);
			break;
		case "addInventory":
			logger.info("adding inventory");
			boolean save = addInventory(request);
			if(save)
				dispatcher = request.getRequestDispatcher("jsp/addInventory.jsp");
				dispatcher.forward(request, response);
			break;
		default:
			break;
		}
	}

	private boolean addInventory(HttpServletRequest request) {

		InventoryForm inventoryForm = new InventoryForm(Integer.parseInt(request.getParameter("inventoryId")), null,
				null, 0, Double.parseDouble(request.getParameter("inventoryQuantity")), null);
		InventoryService inventoryService = new InventoryService();
		return inventoryService.addInventoryQuantity(inventoryForm);
	}

	private void printInventoryItem(HttpServletRequest request, HttpServletResponse response) throws IOException,
			JSONException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");
		String dishName = request.getParameter("itemName");
		InventoryService inventoryService = new InventoryService();
		InventoryForm inventoryForm = inventoryService.getInventoryItem(dishName);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("inventoryId", inventoryForm.getInventoryId());
		jsonObject.put("inventoryName", inventoryForm.getInventoryName());
		jsonObject.put("inventoryCategory", inventoryForm.getCategory());
		jsonObject.put("inventoryQuantity", inventoryForm.getQuantity());
		jsonObject.put("inventoryUnit", inventoryForm.getUnit());
		out.println(jsonObject.toString());
		out.close();

	}

	public void printData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");
		InventoryService inventoryService = new InventoryService();
		String term = request.getParameter("term");
		JSONArray arrayObj = inventoryService.getAllInventoryItems(term);
		out.println(arrayObj.toString());
		out.close();

	}

}
