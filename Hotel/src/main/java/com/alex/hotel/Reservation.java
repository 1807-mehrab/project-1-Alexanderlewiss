package com.alex.hotel;
import java.sql.Date;  

public class Reservation {
	private int id; 
	private Date dateIn; 
	private Date dateOut; 
	private String userID; 
	private String status; 
	private String roomNum; 
	
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn(Date dateIn) {
		
		this.dateIn = dateIn;
	}
	public Date getDateOut() {
		return dateOut;
	}
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	} 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 
	public Reservation(int id, Date dateI, Date dateO, String userID, String status, String roomnum) {
		super();
		this.id = id;
		this.dateIn= dateI;
		this.dateOut = dateO; 
		this.userID = userID; 
		this.status = status; 
		this.roomNum = roomnum;
	}
	public Reservation(String gId)
	{
		this.userID = gId; 
	}
	
	@Override
	public String toString()
	{
		return ""+"  Reserved date in: " + dateIn + " |  Reserved date out: " + dateOut +" | Reservation status :" + status + "Room Number" + roomNum + "";
	}
	
	

}
