package com.alex.hotel;
import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationServlet extends HttpServlet{
   
	
	
	@Override
	 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	                         throws ServletException, IOException{
		
		
		   resp.setContentType("text/html"); 
		   PrintWriter o = resp.getWriter();
		
		  
		
		   
		   String dateI = req.getParameter("i"); 
		   String dateO = req.getParameter("p"); 
		   String roomNum = req.getParameter("r");
		   String status = "Booked"; 
		   String gID = req.getParameter("u"); 
		   java.sql.Date dateIn;
		   java.sql.Date dateOut;
		   SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy"); 
		     
		try {
			
			java.util.Date date1 = format.parse(dateI);
			java.util.Date date2 = format.parse(dateO);
			dateIn = new java.sql.Date(date1.getTime());
			dateOut = new java.sql.Date(date2.getTime()); 
			  
				  
			   
			   if(LoginDao.makeReservation( dateIn, dateOut, gID, status, roomNum)) {
				 
				   status = "Booked";
				   resp.sendRedirect("Dashboard.html"); 
			   }
			   else
			   {
				   status = "Available";
				o.println("Error booking reservation"); 
				
			   }
			  
			   
		 
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
		   o.close(); 
		
		
	 }	
	
	
	
}
