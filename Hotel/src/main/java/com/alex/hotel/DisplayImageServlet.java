package com.alex.hotel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

import com.alex.hotel.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayImageServlet extends HttpServlet {

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM IMAGE WHERE P_ID=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Blob blob = rs.getBlob("PHOTO");
				byte bArr[] = blob.getBytes(1, (int) blob.length());
				resp.setContentType("Image/gif");
				OutputStream o = resp.getOutputStream(); 
				o.write(bArr);
				o.flush();
				o.close();
			}
			else
			{
				System.out.println("No Image found with that ID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}
}
