package com.alex.hotel;

import java.sql.CallableStatement;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {

	static public boolean createAccount(String USER_NAME, String PASS, String FIRST_NAME, String LAST_NAME) {
		CallableStatement cs = null;
		boolean created = false;
		Guest g = null;

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "{CALL SP_Create_Account(?,?,?,?)}";
			cs = conn.prepareCall(sql);
			cs.setString(1, USER_NAME);
			cs.setString(2, PASS);
			cs.setString(3, FIRST_NAME);
			cs.setString(4, LAST_NAME);

			g = new Guest(USER_NAME, PASS, FIRST_NAME, LAST_NAME);

			boolean result = cs.execute();

			if (result) {
				created = true;
			} else {
				created = false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return created;

	}

	public static boolean validate(String USER_NAME, String PASS) {
		boolean status = false;

		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM GUEST WHERE USER_NAME=? and PASS=?");
			ps.setString(1, USER_NAME);
			ps.setString(2, PASS);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

			ps.close();
			conn.close();
			// Catches an exception
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public List<Room> viewAvailable() {
		PreparedStatement ps = null;
		Room r = null;
		List<Room> rooms = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
             String sql = "SELECT * FROM ROOM WHERE STATUS=?";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,"Available"); 
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next())
			 {
				 int id = rs.getInt("ID"); 
				 int rNum = rs.getInt("ROOM_NUMBER");
				 String rName = rs.getString("ROOM_NAME"); 
				 String rStatus = rs.getString("STATUS"); 
				 r = new Room(id, rNum, rName, rStatus); 
				 rooms.add(r); 
			 }
			rs.close();
			ps.close();
			conn.close();
			// Catches an exception
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rooms; 
	}
	static public boolean makeReservation( java.sql.Date dateIn, java.sql.Date dateOut, String GUEST_USER_ID, String STATUS, String ROOM_NUM) {
		CallableStatement cs = null;
		boolean created = true;
		Reservation r = null;
		PreparedStatement ps = null;
		PreparedStatement pss = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			//String sql = "{CALL SP_MAKE_RESERVATION(?,?,?,?,?,?)}";
			String sql = "INSERT INTO RESERVATION (DATE_IN, DATE_OUT, GUEST_USER_ID, STATUS, ROOM_NUM) values(?,?,?,?,?)";
			ps = conn.prepareCall(sql);
			//cs.setInt(1, ID);
			ps.setDate(1, dateIn);
			ps.setDate(2, dateOut);
			ps.setString(3, GUEST_USER_ID);
			ps.setString(4, STATUS);
			ps.setString(5, ROOM_NUM);
			
			r = new Reservation(dateIn, dateOut, GUEST_USER_ID, STATUS, ROOM_NUM);

			boolean result = ps.execute();

			if (!result) {
				String sqll = "UPDATE ROOM SET STATUS = 'Booked' WHERE ROOM_NUMBER = '"+ROOM_NUM +"' "  ;
				pss = conn.prepareStatement(sqll);
				//pss.setString(1, ROOM_NUM);
				pss.executeUpdate(sqll);
				created = true;
			} else {
				created = false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return created;
		
	 }
	public List<Reservation>  viewRes(String GUEST_USER_ID){
		
		PreparedStatement ps = null;
		Reservation r = null;
		List<Reservation> res = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM RESERVATION WHERE GUEST_USER_ID=?"; 
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,GUEST_USER_ID); 
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next())
			 {
				// int id = rs.getInt("ID");
				 Date d_In = rs.getDate("Date_IN"); 
				 Date d_Out = rs.getDate("Date_OUT");
				 String g_id = rs.getString("GUEST_USER_ID");
				 String s = rs.getString("STATUS"); 
				 String rNum = rs.getString("ROOM_NUM"); 
				 r = new Reservation(d_In, d_Out,g_id, s, rNum); 
				 res.add(r); 
			 }
			rs.close();
			ps.close();
			conn.close();
			// Catches an exception
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return res; 
		
	}
	public static boolean validateH(String USER_N, String PASS_H) {
		boolean status = false;

		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM HOSTT WHERE USER_N=? and PASS_H=?");
			ps.setString(1, USER_N);
			ps.setString(2, PASS_H);

			ResultSet rs = ps.executeQuery();
				
			
			status= rs.next();

			ps.close();
			conn.close();
			// Catches an exception
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		    return status;	
		
	}
	
	public List<Room> viewAll() {
		PreparedStatement ps = null;
		Room r = null;
		List<Room> rooms = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
             String sql = "SELECT * FROM ROOM"; 
			 ps = conn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next())
			 {
				 int id = rs.getInt("ID"); 
				 int rNum = rs.getInt("ROOM_NUMBER");
				 String rName = rs.getString("ROOM_NAME"); 
				 String rStatus = rs.getString("STATUS"); 
				 r = new Room(id, rNum, rName, rStatus); 
				 rooms.add(r); 
			 }
			   rs.close();
			   ps.close();
			   conn.close();
			// Catches an exception
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		      return rooms; 
	            	
	   }
	
     public List<Guest> viewAllG(){
    	 
    	PreparedStatement ps = null;
 		Guest g = null;
 		List<Guest> guests = new ArrayList<>();

 		try (Connection conn = ConnectionUtil.getConnection()) {
              String sql = "SELECT * FROM GUEST"; 
 			 ps = conn.prepareStatement(sql);
 			 ResultSet rs = ps.executeQuery();
 			 
 			 while(rs.next())
 			 {
 				 String id = rs.getString("USER_NAME"); 
 				 String pass = rs.getString("PASS");
 				 String fName = rs.getString("FIRST_NAME"); 
 				 String lName = rs.getString("LAST_NAME"); 
 				 g = new Guest(id, pass, fName, lName); 
 				 guests.add(g); 
 			 }
 			   rs.close();
 			   ps.close();
 			   conn.close();
 			// Catches an exception
 		} catch (Exception ex) {
 			ex.printStackTrace();
 		}
 		      return guests; 
    	 
     }
    public static boolean createTicket(int state, String uId, String t, String mes)
    {
    	int created = 0; 
    	boolean c = true; 
    	Ticket tt; 
		try(Connection conn = ConnectionUtil.getConnection()){
			
		String sql = "INSERT INTO TICKET ( ACTIVE, USERID, MTOPIC, MESSAGE) VALUES ( ?, ?, ?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, state);
		ps.setString(2, uId);
		ps.setString(3, t);
		ps.setString(4, mes);
		
		tt = new Ticket(state, uId , t, mes);
		
		ResultSet rs; 
	   rs =  ps.executeQuery();
	 
	   while(rs.next())
	   {
		 
	   }
	   
	    ps.close();
	    rs.close();
	    conn.close();
	    
		}catch (Exception ex) {
 			ex.printStackTrace();
 		     }
		
			return c; 
			
    }
    
    public static boolean respondTicket(String uId)
    {
    	boolean responded = true; 
    	PreparedStatement ps = null; 
    	try(Connection conn = ConnectionUtil.getConnection()){
    		
    		String sql = "UPDATE TICKET SET ACTIVE = 0 WHERE USERID = ?"; 

    	
    	    ps = conn.prepareStatement(sql);
    	    ps.setString(1, uId);
    	    ResultSet rs; 
    		rs =  ps.executeQuery();
    		
    		ps.close();
    	    rs.close();
    	    conn.close();
    	    
    	    
    		
    		
    	}catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	return responded;
    	
    }
    
    public List<Ticket> viewMessage(String uId)
    {
    	PreparedStatement ps = null;
    	Ticket t = null; 
    	List<Ticket> tics = new ArrayList<>();
    	try(Connection conn = ConnectionUtil.getConnection()){
    		
    		String sql = "SELECT * FROM TICKET WHERE USERID = ?"; 

    	
    	    ps = conn.prepareStatement(sql);
    	    ps.setString(1, uId);
    	    ResultSet rs; 
    		rs =  ps.executeQuery();
    		
    		 while(rs.next())
 			 {
 				 int state = rs.getInt("ACTIVE"); 
 				 String un = rs.getString("USERID");
 				 String topic = rs.getString("MTOPIC"); 
 				 String mes = rs.getString("MESSAGE"); 
 				 t = new Ticket(state, un, topic, mes); 
 				 tics.add(t); 
 			 }
    		
    		
    		
    		
    		ps.close();
    	    rs.close();
    	    conn.close();
    	    
    	    
    		
    		
    	}catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	return tics;
    }
    
    public List<Guest> viewProfile(String uId)
    {
    	PreparedStatement ps = null;
    	Guest g = null; 
    	List<Guest> profile = new ArrayList<>();
    	
    	try (Connection conn = ConnectionUtil.getConnection()) {
			 ps = conn.prepareStatement("SELECT * FROM GUEST WHERE USER_NAME = ?");

			ps.setString(1, uId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			 {
				 String un = rs.getString("USER_NAME"); 
				 String pass = rs.getString("PASS");
				 String fName = rs.getString("FIRST_NAME"); 
				 String lName = rs.getString("LAST_NAME"); 
				 g = new Guest(un, pass, fName, lName); 
				 profile.add(g); 
			 }
			
			ps.close();
    	    rs.close();
    	    conn.close();
			
			
    	}catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	return profile; 
    	
    }
    public static boolean updateProfile(String uId, String password, String firstName, String lastName, String userToUpdate)
    {
    	PreparedStatement ps = null;
    	
    	boolean updated = true; 
    	try (Connection conn = ConnectionUtil.getConnection()) {
    		
    		String sql = "UPDATE GUEST SET USER_NAME ='"+ uId +"',PASS='" + password + "', FIRST_NAME='"+ firstName +"', LAST_NAME='"+lastName+"' WHERE USER_NAME ='"+userToUpdate +"' ";
    		ps = conn.prepareStatement(sql);
    		ps.execute();
    		
    	 
    	
    		ps.close();
    	  
    	    conn.close();
    			
    		
    		
    	}catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	return updated; 
    	
    }
    
}
       
 
  
