package com.alex.hotel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProfileServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
		
		LoginDao dao = new LoginDao(); 
		String G_ID = req.getParameter("u");
		String pass = req.getParameter("p");
		String fName = req.getParameter("f");
		String lName = req.getParameter("l");
		String userToUpdate = req.getParameter("uu");
		
		Guest g = new Guest(G_ID,pass,fName,lName);
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter(); 
		
		if(dao.updateProfile(G_ID,pass,fName,lName,userToUpdate))
	    {
	    	resp.sendRedirect("Dashboard.html");
	    }
	    else
	    {
	    	System.out.println("Could not update profile");
	    }
	   
		
		
		
	
	}
	
	
}
