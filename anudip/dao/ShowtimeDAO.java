package org.anudip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.anudip.model.Showtime;
import org.anudip.util.DBConnection;

public class ShowtimeDAO {
	public List<Showtime>findByMovieId(int movieId)
	{
		List<Showtime> list=new ArrayList<>();
		String sql="SELECT id, movie_id, screen_id, show_time, price FROM showtime WHERE movie_id=?";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery())
		{
			while(rs.next())
			{
				Showtime s=new Showtime();
				s.setId(rs.getInt("id"));
				s.setMovieId(rs.getInt("movie_id"));
				s.setScreemId(rs.getInt("screen_id"));
				Timestamp ts=rs.getTimestamp("show_time");
				if(ts!=null)
				{
					s.setShowTime(ts.toLocalDateTime());
				}
				s.setPrice(rs.getBigDecimal("price"));
				list.add(s);
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
		
	}
	public static Showtime findById(int id)
	{
		String sql="SELECT id, movie_id, screen_id, show_time, price FROM showtime WHERE id=?";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement ps= conn.prepareStatement(sql))
		{
			ps.setInt(1, id);
			try(ResultSet rs=ps.executeQuery())
			{
				if(rs.next()) {
					Showtime s=new Showtime();
					s.setId(rs.getInt("id"));
					s.setMovieId(rs.getInt("movie_id"));
					s.setScreemId(rs.getInt("screen_id"));
					Timestamp ts=rs.getTimestamp("show_time");
					if(ts!=null)s.setShowTime(ts.toLocalDateTime());
					s.setPrice(rs.getBigDecimal("price"));
					return s;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
