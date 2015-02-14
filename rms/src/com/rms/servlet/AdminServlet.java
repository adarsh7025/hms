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
import com.rms.service.AdminService;

/**
 * Servlet implementation class AdminServlet
 * @author kv
 */
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private final Logger logger = LoggerFactory.getLogger(BillingDAO.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest( request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest( request,  response);
	}
	
	/**
	 * @see HttpServlet#doRequest(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		logger.info("Admin get user");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin.jsp");
//		AdminService adminService= new AdminService();
//		adminService.getUser();
//		
//		request.setAttribute("dishes", adminService);
//		logger.info("Sending USERinformation to admin");
//		dispatcher.forward(request, response);
		
		
		
		String userId = (request.getParameter("username")).trim();
		String password = (request.getParameter("password")).trim();
		String name=(request.getParameter("name").trim());
		String type=(request.getParameter("type")).trim();
		long phonenumber=(Long.valueOf(request.getParameter("phonenumber").trim())).longValue();
		int locationId=Integer.parseInt(request.getParameter("locationid").trim());
		
		UserForm userform=new UserForm();
		userform.setUserId(userId);
		userform.setPassword(password);
		userform.setName(name);
		userform.setType(type);
		userform.setPhoneNo(phonenumber);
		userform.setParent(101);
		userform.setLocationId(locationId);

		AdminService adminservice=new AdminService();
		adminservice.addUser(userform);
		
		
		
		
	}

}
