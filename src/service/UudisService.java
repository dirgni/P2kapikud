// Koostab vajaliku SQL käsu ja võtab andmebaasist andmed. 
// Täidab objektid andmetega ja tagastab.
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DatabaseConnectionFactory;
import object.Uudis;

public class UudisService {
	
	public Uudis getRandomUudis() {
		//TODO
		
		return null;
	}
	
	public Uudis getUudisById(int id) {
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Uudis uudis;
		try {
			Connection con = dcf.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"SELECT pealkiri, tekst, pilt FROM uudis "
					+ "WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rsUudis = ps.executeQuery();
			
			uudis = new Uudis();
			
			rsUudis.next();
			uudis.setPealkiri(rsUudis.getString("pealkiri"));
			uudis.setTekst(extractParagraphs(rsUudis.getString("tekst")));
			uudis.setPilt(rsUudis.getString("pilt"));
			
			return uudis;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public boolean publishUudis(int ajakirjanikId, 
			String pealkiri, String tekst, String pilt) {
		// TODO
		
		return false;
	}
	
	public Uudis[] search(String pattern) {
		//TODO
		
		return null;
	}
	
	private String[] extractParagraphs(String tekst) {
		String[] lõigud = tekst.trim().split("\n");
		
		for (String lõik : lõigud) {
			lõik.trim();
		}
		
		return lõigud;
	}
}
