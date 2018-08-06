package com.alex.hotel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RespondTicketServlet extends HttpServlet {
	

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String userId = req.getParameter("u");
		String mes = null; 
		resp.setContentType("text/html"); 
		
		if(LoginDao.respondTicket(userId)) {
			 
			 resp.sendRedirect("hDashboard.html");
		 }
		 else
		 {
			  
			 mes = "Cannot respond to ticket"; 
		 }
		 req.setAttribute("mes", mes);
		
	}

}
