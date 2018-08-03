package com.alex.hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HostLoginSurvlet extends HttpServlet{

	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			                throws ServletException, IOException{
		 
		 resp.setContentType("text/html"); 
		 PrintWriter o = resp.getWriter();
		   
		 String userName = req.getParameter("u");
		 String passWord = req.getParameter("p"); 
		    if(LoginDao.validateH(userName, passWord))
		    {
		    	resp.sendRedirect("hDashboard.html");
		    }
		    else
		    {
		     o.println("Invalid passwrod or user ID");
		    	//resp.sendRedirect("index.html");
		    }
		 
		 
		 o.close();
		 
		 
	 }
}
