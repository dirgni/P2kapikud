// Koostab vajaliku SQL käsu ja võtab andmebaasist andmed. 
// Täidab objektid andmetega ja tagastab.
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import object.Uudis;
import connection.DatabaseConnectionFactory;

public class UudisService {
	
	public Uudis getRandomUudis() {
		//TODO
		
		return null;
	}
	
	public ArrayList<Uudis> getKõikUudised() {
		Uudis uudis;
		Date date;
		DateFormat kell = new SimpleDateFormat("HH:mm:ss");
		DateFormat kuupäev = new SimpleDateFormat("dd/MM/yyyy");
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		try {
			Connection con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, pealkiri, tekst, pilt, aeg FROM uudis");
			ResultSet rsUudis = ps.executeQuery();
			
			ArrayList<Uudis> uudised = new ArrayList<Uudis>();
			while (rsUudis.next()) {
				uudis = new Uudis();
				
				
				uudis.setId(rsUudis.getInt("id"));
				uudis.setPealkiri(rsUudis.getString("pealkiri"));
				uudis.setTekst(extractParagraphs(rsUudis.getString("tekst")));
				uudis.setPilt(rsUudis.getString("pilt"));
				
				date = extractDate(rsUudis.getString("aeg"));
				uudis.setKell(kell.format(date));
				uudis.setKuupäev(kuupäev.format(date));
				
				uudised.add(uudis);
			}

			return uudised;
		} catch (SQLException e) {
			System.out.println("getAllUudised  SQLException:");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Uudis getUudisById(int id) {
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Uudis uudis;
		try {
			Connection con = dcf.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, pealkiri, tekst, pilt FROM uudis "
					+ "WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rsUudis = ps.executeQuery();
			
			uudis = new Uudis();
			
			rsUudis.next();
			uudis.setId(rsUudis.getInt("id"));
			uudis.setPealkiri(rsUudis.getString("pealkiri"));
			uudis.setTekst(extractParagraphs(rsUudis.getString("tekst")));
			uudis.setPilt(rsUudis.getString("pilt"));
			
			return uudis;
		} catch (SQLException e) {
			System.out.println("getUudisById SQLExcpetion:");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void publishUudis(int ajakirjanikId, 
			String pealkiri, String tekst, String pilt) {
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO uudis (ajakirjanikId, pealkiri, tekst, pilt) "
					+ "VALUES (?, ?, ?, ?)");
			ps.setInt(1, ajakirjanikId);
			ps.setString(2, pealkiri);
			ps.setString(3, tekst);
			ps.setString(4, pilt);
			
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Uudise postitamine ebaõnnestus!");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @return Pildi asukoht
	 */
	public String uploadPicture() {
		//TODO
		
		return null;
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
	
	private Date extractDate(String aeg) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		try {
			date = df.parse(aeg);
			return date;
		} catch (ParseException e) {
			System.out.println("Kuupäeva parsimise error!");
			e.printStackTrace();
		}
		
		return null;
	}
}
