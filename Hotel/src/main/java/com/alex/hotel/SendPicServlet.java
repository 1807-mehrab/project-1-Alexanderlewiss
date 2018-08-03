package com.alex.hotel;

import javax.servlet.http.HttpServlet;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

@WebServlet("/imgUpload")
@MultipartConfig(maxFileSize = 16177215) // ensures that the file size can only be 16mb
public class SendPicServlet  extends HttpServlet{

	private static final long serialVersionUID = -1623656324694499109L;
	
	protected void doPost(HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
		
		InputStream iS = null;
		Part fP = req.getPart("image");
		if(fP != null) {
			System.out.println(fP.getName());
            System.out.println(fP.getSize());
            System.out.println(fP.getContentType());
            iS = fP.getInputStream();
		}
		
		String mes = null; 
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			    PreparedStatement ps = null;
	            String sql = "INSERT INTO IMAGE (PHOTO) values (?)";
	           ps = conn.prepareStatement(sql);
	           
	            if (iS != null) {
	                // fetches input stream of the upload file for the blob column
	                ps.setBlob(1, iS);
	            }

	            // sends the statement to the database server
	            int row = ps.executeUpdate();
	            if (row > 0) {
	                mes = "Sucessfuly uploaded image! ";
	            }
	        } catch (SQLException ex) {
	            mes = "ERROR: " + ex.getMessage();
	            ex.printStackTrace();
	        }
		
		       // Sets messgae in request 
		      req.setAttribute("mes", mes);
		      // Sends message to jsp page.
		      getServletContext().getRequestDispatcher("/submit.jsp").forward(
		                req, res);
		
		
	}
	
	
	
}
