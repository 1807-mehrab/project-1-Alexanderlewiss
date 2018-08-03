package com.alex.hotel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAllGuestsServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
		
		 LoginDao dao = new LoginDao(); 
	        List<Guest> guests = dao.viewAllG(); 
	        resp.setContentType("text/html");
	        HtmlUtils hu = new HtmlUtils(); 
	        PrintWriter pw = resp.getWriter(); 
	        pw.print(hu.createHtmlHeader("All Guest"));
	        pw.print(hu.getTableHead("center", 1));

	        pw.print(hu.getTH("center", "Here are all the guest in the database"));


	        Vector av = new Vector();
	        pw.println("<body bgcolor=\"black\">");
	        pw.println("<link rel='stylesheet' type='text/css' href='stylea.css' />");
	        for(Guest g: guests)
	        {

	        	av.addElement(g.toString());

	        }
	        pw.print(hu.getTableContents("center", av, 1));
	        pw.print(hu.getHtmlFooter());
	        pw.println("<a href=\'hDashboard.html'\'>Return to Dashboard<'\'a>");


	        pw.close();
	        }
	
	}
