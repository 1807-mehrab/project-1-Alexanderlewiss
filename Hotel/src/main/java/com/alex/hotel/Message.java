package com.alex.hotel;

public class Message {
	private String mes; 
	private String sender; 
	private int mesNum;
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public int getMesNum() {
		return mesNum;
	}
	public void setMesNum(int mesNum) {
		this.mesNum = mesNum;
	} 
	public Message() {
		super(); 
	}
	public Message(String mes, String sender) {
		super(); 
		this.mes = mes; 
		this.sender = sender; 
		
	}
	public Message(String mes, String sender, int mesNum) {
		super();
		this.mes = mes; 
		this.sender = sender; 
		this.mesNum = mesNum; 
	}
	

}
