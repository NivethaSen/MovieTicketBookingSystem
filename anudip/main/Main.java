package org.anudip.main;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.anudip.dao.BookingDAO;
import org.anudip.dao.MovieDAO;
import org.anudip.dao.SeatDAO;
import org.anudip.dao.ShowtimeDAO;
import org.anudip.model.Movie;
import org.anudip.model.Seat;
import org.anudip.model.Showtime;


public class Main {
	private static final MovieDAO movieDAO=new MovieDAO();
	private static final ShowtimeDAO showDAO=new ShowtimeDAO();
	private static final SeatDAO seatDAO=new SeatDAO();
	private static final BookingDAO bookingDAO=new BookingDAO();
	private static final Scanner sc=new Scanner(System.in); 
	public static void main(String[] args) {
		System.out.println("Welcome to Movie Ticket Booking (Console Demo)");
		while(true)
		{
			System.out.println("\n1)List Movies\n2) View Shows for Movie\n3)Exit");
			System.out.println("Choose:");
			String choice=sc.nextLine();
			switch(choice)
			{
			case"1":
				listMovies();
			
			case"2":
				viewShowAndBook();
				
			case"3":
				System.out.println("Bye!");
				return;
		    default:
		    	System.out.println("Invalid option");	
		   	}
		}
		
			
    	}
		private static void listMovies()
		{
			List<Movie>movies=movieDAO.findALL();
			System.out.println("Movies:");
			for(Movie m:movies) {
				System.out.printf("%d)%s(%d min)-%s%n",m.getId(), m.getTitle(), m.getDurationMinutes(),
						m.getLanguage());
			}
		}
		private static void viewShowAndBook() {
			System.out.println("Enter movie id:");
			int movieId=Integer.parseInt(sc.nextLine());
			List<Showtime> shows=showDAO.findByMovieId(movieId);
			if(shows.isEmpty()) {
				System.out.println("No shows found for that movie.");
				return;
			}
			DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			System.out.println("Shows:");
			for (Showtime s: shows) {
				System.out.printf("%d) screen %d at %s - price %.2f%n",
						s.getId(),
				        s.getScreemId(),
				        s.getShowTime().format(fmt),
				        s.getPrice());
			}
			System.out.println("Enter show id to view seats / book (or 0 to cancel):");
			int showId=Integer.parseInt(sc.nextLine());
			if(showId == 0) return;
			Showtime chosen = ShowtimeDAO.findById(showId);
			if(chosen == null) {
				System.out.println("Show not found.");
				return;
			}
			List<Seat> seats=SeatDAO.findByScreenId(chosen.getScreemId());
			System.out.println("Seats (SeatId : seatNo) - 'X' means booked for this show:");
			for (Seat seat:seats) {
				boolean booked=bookingDAO.isSeatBookedForShow(showId, seat.getId());
				System.out.printf("%d:%s %s%n", seat.getId(),
						seat.getSeatNo(),
						booked?"(X)":"");
			}
			System.out.println("Enter seat id to book(or 0 to cancel):");
			int seatId=Integer.parseInt(sc.nextLine());
			if(seatId == 0) return;
			System.out.println("Enter your Name: ");
			String name=sc.nextLine().trim();
			BigDecimal price=chosen.getPrice();
			int bookingId=bookingDAO.createBooking(showId, seatId, name, price);
			if(bookingId > 0) {
				System.out.println("Booking confirmed. Booking id:" + bookingId);
			}
			else {
				System.out.println("Booking failed - seat may already be booked.");
			}
		}
		public static SeatDAO getSeatdao() {
			return seatDAO;
		}
}
