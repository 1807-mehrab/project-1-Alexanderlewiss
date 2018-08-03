package com.alex.hotel;
import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HotelServlet extends HttpServlet{
	
	
		
	   @SuppressWarnings("serial")
		@Override
		 
			
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		                         throws ServletException, IOException{
			
			
			   resp.setContentType("text/html"); 
			   PrintWriter o = resp.getWriter();
			   
			   String userName = req.getParameter("u"); 
			   String passWord = req.getParameter("p"); 
			   String firstName = req.getParameter("f"); 
			   String lastName = req.getParameter("l"); 
			    
			   
			   if(LoginDao.createAccount(userName, passWord, firstName, lastName)) {
				   
				   resp.sendRedirect("Login.html"); 
			   }
			   else
			   {
				   
				resp.sendRedirect("index.html"); 
				
			   }
			   
			   o.close(); 
			
			
		 }	
		 
}
