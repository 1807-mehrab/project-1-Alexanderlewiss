package com.alex.hotel;

import java.util.ArrayList;

public class Ticket {
	private int id;
	private boolean state;
	private String uId; 
	private String t; 
	private String message; 
	
	
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	} 
	
	public void setsState(int state) {
		if(state == 1)
		{
			this.state = true; 
		}
		else this.state = false; 
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Ticket() {
		super(); 
	}
	
	public Ticket( int state, String uId, String t, String message ) {
		super(); 
		this.uId = uId; 
		this.t = t; 
		this.message = message; 
		if(state == 1) {
			this.state = true; 
		}
		else this.state = false; 
		
	}
	
	public Ticket(String uid) {
		
		this.uId = uid; 
	}
	
	
	@Override
	public String toString()
	{
		return ""+"  Ticket state: " + state + " |  User: " + uId +" | Message topic : " + t + "| Message: " + message + "";
	}
	

}
