package com.alex.hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/updateI")
public class UpdateInfoServlet extends HttpServlet{

	private static final long serialVersionUID = -1623656324694499109L;
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			                throws ServletException, IOException{
		resp.setContentType("text/html");
		String userName = req.getParameter("User_Name");
	    String password = req.getParameter("Pass");
	    String firstName = req.getParameter("First_Name");
	    String lastName = req.getParameter("Last_Name");
	    String u = "Ahs282";
	    PreparedStatement ps = null; 
	    try (Connection conn = ConnectionUtil.getConnection()) {
	    	
	    	String sql = "UPDATE GUEST SET USER_NAME ='"+userName +"',PASS='" + password + "', FIRST_NAME='"+ firstName +"', LAST_NAME='"+lastName+"' WHERE USER_NAME ='"+u +"' ";;
	       ps = conn.prepareStatement(sql);
	       ps.executeQuery();
	    		
	    	
	    }catch (SQLException ex) {
            ex.printStackTrace();
        }
	    
	    
	    getServletContext().getRequestDispatcher("/updatedProfile.jsp").forward(
                req, resp);

		
		
	}
	
	
}
