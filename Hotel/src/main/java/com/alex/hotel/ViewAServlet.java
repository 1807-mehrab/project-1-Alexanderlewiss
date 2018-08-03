package com.alex.hotel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.alex.hotel.LoginDao;
import com.alex.hotel.Room; 
import com.fasterxml.jackson.databind.ObjectMapper;

public class ViewAServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			                         throws ServletException, IOException{
	
		LoginDao dao = new LoginDao(); 
		List<Room> rooms = dao.viewAvailable(); 
		resp.setContentType("text/html");
		HtmlUtils hu = new HtmlUtils(); 
		PrintWriter pw = resp.getWriter(); 
		pw.print(hu.createHtmlHeader("Available Rooms"));
		pw.print(hu.getTableHead("center", 1));

	    pw.print(hu.getTH("center", "Rooms that are available to book"));
	

	    Vector av = new Vector();
	    pw.println("<body bgcolor=\"black\">");
	    pw.println("<link rel='stylesheet' type='text/css' href='stylea.css' />");
	    for(Room r: rooms)
		{
		  
           av.addElement(r.toString());

		}
	    pw.print(hu.getTableContents("center", av, 1));
	    pw.print(hu.getHtmlFooter());
	    pw.println("<a href=\'Dashboard.html'\'>Return to Dashboard<'\'a>");
	  
		
	    pw.close();
		
		
	    
	    
		
	}
	
	
	
	

}
