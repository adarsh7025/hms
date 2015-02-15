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

import com.rms.dao.BillingDAO;
import com.rms.dao.UserDAO;
import com.rms.formentity.UserForm;
import com.rms.service.AdminService;

/**
 * Servlet implementation class AdminServlet2
 */
@WebServlet(name = "Admin2", urlPatterns = { "/Admin2" })
public class AdminServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final Logger logger = LoggerFactory.getLogger(UserDAO.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRequest( request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRequest( request,  response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//adminService.getUser();
//		
//		request.setAttribute("dishes", adminService);
		
//		dispatcher.forward(request, response);
		
		logger.info("Admin Servlet2");
		
		String userId = (request.getParameter("username")).trim();
		String password = (request.getParameter("password")).trim();
		String name=(request.getParameter("name").trim());
		String type=(request.getParameter("type")).trim();
		long phonenumber=(Long.valueOf(request.getParameter("phonenumber").trim())).longValue();
		int locationId=Integer.parseInt(request.getParameter("location").trim());
		int parent=101;
		System.out.println(userId+" "+phonenumber+" ");
		logger.info("Admin get user2");
		
		UserForm userform=new UserForm(10, userId,password,name,type,locationId,parent,phonenumber);
		
		//UserForm userform=new UserForm(10,"1","1","1","1",1,1,1);
		AdminService adminservice=new AdminService();
		boolean b=adminservice.addUser(userform);
		logger.info("Sending USERinformation to admin");
        request.setAttribute("b", b);
    	
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/adminMessage.jsp");
		
		dispatcher.forward(request, response);                    	
	}

}
