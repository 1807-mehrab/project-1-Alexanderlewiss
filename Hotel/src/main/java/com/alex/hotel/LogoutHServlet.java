package com.alex.hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutHServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  

            request.getRequestDispatcher("hDashboard.html").include(request, response);  

            HttpSession session=request.getSession();  
            session.invalidate();  
            response.setContentType("text/html");
            HtmlUtils hu = new HtmlUtils(); 
           
            response.sendRedirect("hostLogin.html");
           
            out.close();  
	}
}
