package com.alex.hotel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewProfileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
		LoginDao dao = new LoginDao(); 
		String G_ID = req.getParameter("u");
		Guest g = new Guest(G_ID);
		List<Guest> profile = dao.viewProfile(G_ID); 
		resp.setContentType("text/html");
		HtmlUtils hu = new HtmlUtils(); 
		PrintWriter pw = resp.getWriter(); 
		
		
		pw.print(hu.createHtmlHeader("Your Reservations"));
		pw.print(hu.getTableHead("center", 1));
		Vector av = new Vector();
	    pw.println("<body bgcolor=\"black\">");
	    pw.println("<link rel='stylesheet' type='text/css' href='stylea.css' />");
	    
	    for(Guest gg: profile)
	    {
	    	av.addElement(gg.toString());
	    }
	    pw.print(hu.getTableContents("center", av, 1));
	    pw.print(hu.getHtmlFooter());
	    pw.println("<a href=\'Dashboard.html'\'>Return to Dashboard<'\'a>");
	  
		
	    pw.close();
		
	}
}
