package com.rms.servlet;

import java.io.IOException;

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
import com.rms.formentity.UserForm;
import com.rms.service.UserService;

/**
 * Servlet implementation class AuthenticateUserServlet authenticates username
 * and password
 * 
 * @author hegde_a
 *
 */
@WebServlet("/AuthenticateUser")
public class AuthenticateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(BillingDAO.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticateUserServlet() {
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
		logger.info("Authenitcating user");

		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		UserForm userForm = new UserForm();
		userForm.setUserId(userName);
		userForm.setPassword(password);
		UserService userService = new UserService();
		UserForm userForm2 = userService.authenticateUser(userForm);
		System.out.println(userForm2);

		if (null == userForm2) {
			logger.info("Authentication failure");
		} else {
		
			logger.info("Login successful!");
			String userType = userForm2.getType();
			session.setAttribute("userId", userForm2.getUserId());
			session.setAttribute("userType", userType);

			switch (userType) {

			case "kioskoperator":
				dispatcher = request.getRequestDispatcher("jsp/kioskOperator.jsp");
				break;
			case "supervisor":
				dispatcher = request.getRequestDispatcher("jsp/supervisor.jsp");
				break;
			case "manager":
				dispatcher = request.getRequestDispatcher("jsp/manager.jsp");
				break;
			case "admin":
				dispatcher = request.getRequestDispatcher("jsp/admin.jsp");
				break;
			default:
				logger.info("Incorrect usertype for user");
			}
			dispatcher.include(request, response);
		}
	}
}
