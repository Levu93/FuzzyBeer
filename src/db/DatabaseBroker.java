package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import domen.Beer;

public class DatabaseBroker {

	public LinkedList<Beer> findBeerStyle(String[] beerStyles){
		LinkedList<Beer> beers = new LinkedList<Beer>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuzzybeer","root", "");
			String query = "select * from beer b inner join beerstyle bs on b.stil = bs.beerStyleID where bs.name in (?, ?, ?) order by 1 desc";
			PreparedStatement statement = conn.prepareStatement(query);
			for (int i = 0; i < beerStyles.length; i++) {
				statement.setString(i+1, beerStyles[i]);
			}
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String naziv = rs.getString("beerName");
				String alkohol = rs.getString("alkohol");
				String proizvodjac = rs.getString("proizvodjac");
				String zemlja = rs.getString("zemlja");
				String info = rs.getString("info");
				String stil = rs.getString("name");	
				
				Beer beer = new Beer(naziv, alkohol, proizvodjac, zemlja, info, stil);
				beers.add(beer);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beers;
	}
	
}
