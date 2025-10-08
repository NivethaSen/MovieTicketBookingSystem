package org.anudip.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.anudip.util.DBConnection;

public class BookingDAO {
	public int createBooking(int showtimeId, int seatId, String customerName, BigDecimal pricePaid)
	{
		String sql="INSERT INTO booking(showtime_id, seat_id, customer_name, price_paid)VALUES(?,?,?)";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
		{
			conn.setAutoCommit(false);
			ps.setInt(1, showtimeId);
			ps.setInt(2, seatId);
			ps.setString(3, customerName);
			ps.setBigDecimal(4, pricePaid);
			ps.executeUpdate();
			try(ResultSet keys=ps.getGeneratedKeys())
			{
				if(keys.next())
				{
					int bookingId=keys.getInt(1);
					conn.commit();
					return bookingId;
				}
			}
		}
		catch(SQLException e)
		{
			System.err.print("Booking failed:"+ e.getMessage());
		}
		return-1;
	}
	public boolean isSeatBookedForShow(int showtimeId, int seatId)
	{
		String sql="SELECT COUNT(*) FROM booking WHERE showtime_id=? AND seat_id=?";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql))
		{
			ps.setInt(1, showtimeId);
			ps.setInt(2, seatId);
			try(ResultSet rs=ps.executeQuery())
			{
				if(rs.next())
				{
					return rs.getInt(1)>0;
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
