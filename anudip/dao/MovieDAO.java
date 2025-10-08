package org.anudip.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.anudip.model.Movie;
import org.anudip.util.DBConnection;

public class MovieDAO {
	public List<Movie>findALL(){
		List<Movie>list=new ArrayList<>();
		String sql="SELECT id, title, duration_minutes, language, description From movie";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement ps= conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery()){
			while(rs.next()) {
				Movie m=new Movie();
				m.setId(rs.getInt("Id"));
				m.setTitle(rs.getString("Title"));
				m.setDurationMinutes(rs.getInt("duration_minutes"));
				m.setLanguage(rs.getString("language"));
				m.setDescription(rs.getString("description"));
				list.add(m);
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
		
		
	}

}
