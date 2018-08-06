package com.alex.hotel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewTicketServlet  extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
		LoginDao dao = new LoginDao(); 
		String G_ID = req.getParameter("u");
		Ticket t = new Ticket(G_ID);
		List<Ticket> tic = dao.viewMessage(G_ID); 
		resp.setContentType("text/html");
		HtmlUtils hu = new HtmlUtils(); 
		PrintWriter pw = resp.getWriter();
		
		pw.print(hu.createHtmlHeader("Your tickets"));
		pw.print(hu.getTableHead("center", 1));
		Vector av = new Vector();
	    pw.println("<body bgcolor=\"black\">");
	    pw.println("<link rel='stylesheet' type='text/css' href='stylea.css' />");
	    
	    for(Ticket tt: tic)
	    {
	    	av.addElement(tt.toString());
	    }
	    pw.print(hu.getTableContents("center", av, 1));
	    pw.print(hu.getHtmlFooter());
	    pw.println("<a href=\'Dashboard.html'\'>Return to Dashboard<'\'a>");
	  
		
	    pw.close();
		
		
	}
}
