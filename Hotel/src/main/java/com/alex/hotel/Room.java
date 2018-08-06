package com.alex.hotel;

public class Room {
	
	private int rID; 
	private int rNUM; 
	private String rName; 
	private String rStatus;
	public int getrID() {
		return rID;
	}
	public void setrID(int rID) {
		this.rID = rID;
	}
	public int getrNUM() {
		return rNUM;
	}
	public void setrNUM(int rNUM) {
		this.rNUM = rNUM;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	} 
	
	public Room(int rID, int rNUM, String rName, String rStatus) {
		super();
		this.rID = rID; 
		this.rNUM = rNUM;
		this.rName = rName; 
		this.rStatus = rStatus; 
	}
	
	
	
	@Override
	public String toString()
	{
		return ""+"  Room number: " + rNUM + " |  Room name: " + rName +" | Room status :" + rStatus + "";
	}
	

}
