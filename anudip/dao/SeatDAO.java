package org.anudip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.anudip.model.Seat;
import org.anudip.util.DBConnection;

public class SeatDAO {
	public static  List<Seat>findByScreenId(int screenId)
	{
		List<Seat> list=new ArrayList<>();
		String sql="SELECT id, screen_id, seat_no, seat_type FROM seat WHERE screen_id=?";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql))
		{
			ps.setInt(1, screenId);
			try(ResultSet rs=ps.executeQuery())
			{
				while(rs.next())
				{
					Seat s=new Seat();
					s.setId(rs.getInt("id"));
					s.setScreenId(rs.getInt("screen_id"));
					s.setSeatNo(rs.getString("sear_no"));
					s.setSeatType(rs.getString("seat_type"));
					list.add(s);
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
		
	}

	
		
	
	
	
	

}
