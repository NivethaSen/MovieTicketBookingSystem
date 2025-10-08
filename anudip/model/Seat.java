package org.anudip.model;

import jakarta.persistence.Id;

public class Seat {
	@Id
	private int id;
	private int screenId;
	private String seatNo;
	private String seatType;
	public Seat() {
		
	
	}
	public Seat(int id, int screenId, String seatNo, String seatType) {
		super();
		this.id = id;
		this.screenId = screenId;
		this.seatNo = seatNo;
		this.seatType = seatType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	
	
	

}
