package org.anudip.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Id;

public class Booking {
	@Id
	private int id;
	private int showtimeId;
	private int seatId;
	private String customerName;
	private LocalDateTime bookedOn;
	private BigDecimal pricePaid;
	public Booking() {
		
	}
	public Booking(int id, int showtimeId, int seatId, String customerName, LocalDateTime bookedOn,
			BigDecimal pricePaid) {
		super();
		this.id = id;
		this.showtimeId = showtimeId;
		this.seatId = seatId;
		this.customerName = customerName;
		this.bookedOn = bookedOn;
		this.pricePaid = pricePaid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public LocalDateTime getBookedOn() {
		return bookedOn;
	}
	public void setBookedOn(LocalDateTime bookedOn) {
		this.bookedOn = bookedOn;
	}
	public BigDecimal getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(BigDecimal pricePaid) {
		this.pricePaid = pricePaid;
	}
	
	

}
