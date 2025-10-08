package org.anudip.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Id;

public class Showtime {
	@Id
	private int id;
	private int movieId;
	private int screemId;
	private LocalDateTime showTime;
	private BigDecimal price;
	public Showtime() {
	
	}
	public Showtime(int id, int movieId, int screemId, LocalDateTime showTime, BigDecimal price) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.screemId = screemId;
		this.showTime = showTime;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getScreemId() {
		return screemId;
	}
	public void setScreemId(int screemId) {
		this.screemId = screemId;
	}
	public LocalDateTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	

}
