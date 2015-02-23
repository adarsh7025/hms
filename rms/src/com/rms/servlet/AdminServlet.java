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
import com.rms.dao.UserDAO;
import com.rms.formentity.DishForm;
import com.rms.formentity.UserForm;
import com.rms.service.AdminService;
import com.rms.service.DishService;

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
		
		logger.info("AdminServlet");
		String action = ((String) request.getAttribute("action") != null) ? (String) request.getAttribute("action")
				: (String) request.getParameter("action");
		System.out.println(action);
		if(action.equals("addUser"))
		{
			
			
			logger.info("Admin Servlet for adding user");
			
			boolean b=addUser( request,  response);
	    	if(b=true)
	    	{	RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/adminMessage.jsp");
				dispatcher.forward(request, response);                    	
	    	}		 
		}
		
		else if(action.equals("addDish"))
		{
			logger.info("AdminServlet dish add page");	
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/adminDishAdd.jsp");
			dispatcher.forward(request, response);	
		}
		
		else if(action.equals("addDishSubmit"))
		{
			logger.info("AdminServlet add user submit");
			boolean b1=addDish(request, response);
			
			if(b1=true)
			{}
		}
		
		else
		{
			logger.info("AdminServlet default user page");	 
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
	} 
	
	private boolean addDish(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		logger.info("addUser Method");

		String dishname=(request.getParameter("DishName").trim());
		double price=Double.parseDouble((request.getParameter("DishPrice")).trim());
		int id=0;
		double qty=0.0;
		int locId=0;
		
		DishForm dishform=new DishForm(id,dishname,qty,locId,price);
		
		//UserForm userform=new UserForm(10,"1","1","1","1",1,1,1);
		AdminService adminservice=new AdminService();
		boolean b=adminservice.addDish(dishform);
         return b;
		
	}

	public boolean addUser(HttpServletRequest request, HttpServletResponse response)
	{
		
		logger.info("addDish Method");
		String DishName = (request.getParameter("DishName")).trim();
		String password = (request.getParameter("DishCategory")).trim();
		String name=(request.getParameter("LocationId").trim());
		String type=(request.getParameter("DishQuantity")).trim();
		long phonenumber=(Long.valueOf(request.getParameter("DishUnit").trim())).longValue();
		
		//System.out.println(userId+" "+phonenumber+" ");
		
		
		DishForm dishform=new DishForm();
		
		
		AdminService dishservice=new AdminService();
		boolean b=dishservice.addDish(dishform);
	
         return b;
	}

}
