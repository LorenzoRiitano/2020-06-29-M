package it.polito.tdp.imdb.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.imdb.model.Actor;
import it.polito.tdp.imdb.model.Adiacenza;
import it.polito.tdp.imdb.model.Director;
import it.polito.tdp.imdb.model.Movie;

public class ImdbDAO {
	
	public List<Actor> listAllActors(){
		String sql = "SELECT * FROM actors";
		List<Actor> result = new ArrayList<Actor>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Actor actor = new Actor(res.getInt("id"), res.getString("first_name"), res.getString("last_name"),
						res.getString("gender"));
				
				result.add(actor);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Movie> listAllMovies(){
		String sql = "SELECT * FROM movies";
		List<Movie> result = new ArrayList<Movie>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Movie movie = new Movie(res.getInt("id"), res.getString("name"), 
						res.getInt("year"), res.getDouble("rank"));
				
				result.add(movie);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Director> listAllDirectors(){
		String sql = "SELECT * FROM directors";
		List<Director> result = new ArrayList<Director>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Director director = new Director(res.getInt("id"), res.getString("first_name"), res.getString("last_name"));
				
				result.add(director);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void getVertici(int anno, Map<Integer, Director> map) {
		// TODO Auto-generated method stub
		String sql = "SELECT d.* "
				+ "FROM directors AS d, movies_directors AS md, movies AS m "
				+ "WHERE d.id=md.director_id AND md.movie_id=m.id AND m.year=? "
				+ "GROUP BY d.id";
		//Map<Integer,Director> result = new HashMap<Integer,Director>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				if(!map.containsKey(res.getInt("id"))) {
        
				Director director = new Director(res.getInt("id"), res.getString("first_name"), res.getString("last_name"));
				map.put(res.getInt("id"), director);
				//result.(director);
			}
			}
			conn.close();
			//return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			//return null;
		}
		
	}

	public List<Adiacenza> getarchi(Map<Integer, Director> map, int anno) {
		// TODO Auto-generated method stub
		String sql = "select md.director_id, md1.director_id,count(distinct r.actor_id) as tot\r\n"
				+ "from roles as r,movies_directors as md,movies as m,roles as r1,movies_directors as md1,movies as m1 \r\n"
				+ "where md.movie_id=r.movie_id "
				+ "and  md.movie_id=m.id "
				+ "and m.year=? "
				+ "and md1.movie_id=r1.movie_id "
				+ "and  md1.movie_id=m1.id "
				+ "and m1.year=? "
				+ "and md.director_id > md1.director_id "
				+ "and r.actor_id=r1.actor_id "
				+ "group by md.director_id, md1.director_id";
		List<Adiacenza> result = new ArrayList<Adiacenza>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	
	
	
	
	
	
}
