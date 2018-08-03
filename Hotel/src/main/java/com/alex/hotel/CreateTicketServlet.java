package com.alex.hotel;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateTicketServlet extends HttpServlet {

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userId = req.getParameter("u");
		String topic = req.getParameter("t"); 
		String message = req.getParameter("m");
		
		 resp.setContentType("text/html"); 
		 PrintWriter o = resp.getWriter();
		 int status = 1;
		 String mes = null; 
		 
		 if(LoginDao.createTicket(status,userId,topic,message)) {
			 status = 1; 
			 resp.sendRedirect("Dashboard.html");
		 }
		 else
		 {
			 status = 0; 
			 mes = "Cannot create ticket"; 
		 }
		 
		 req.setAttribute("mes", mes);
		// getServletContext().getRequestDispatcher("/Create.jsp").forward(
	               // req, resp);
		
		
	}
}
