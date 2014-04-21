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

import object.Kommentaar;
import connection.DatabaseConnectionFactory;

public class KommentaarService {

	public ArrayList<Kommentaar> getKommentaaridByUudisId(int uudisId) {
		System.out.println("getKommentaarByUudisId");
		ArrayList<Kommentaar> kommentaarid = new ArrayList<Kommentaar>();
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT id, nimi, tekst, aeg, uudisId "
					+ "FROM kommentaar WHERE uudisId = ? ORDER BY aeg DESC");
			ps.setInt(1, uudisId);
			ResultSet rsKommentaarid = ps.executeQuery();

			Kommentaar k;
			Date date;
			DateFormat kell = new SimpleDateFormat("HH:mm:ss");
			DateFormat kuupäev = new SimpleDateFormat("dd-MM-yyyy");
			while (rsKommentaarid.next()) {
				k = new Kommentaar();
				k.setId(Integer.parseInt(rsKommentaarid.getString("id")));
				k.setNimi(rsKommentaarid.getString("nimi"));
				k.setTekst(rsKommentaarid.getString("tekst"));
				
				date = extractDate(rsKommentaarid.getString("aeg"));
				k.setKell(kell.format(date));
				k.setKuupäev(kuupäev.format(date));
				
				kommentaarid.add(k);
			}
			
		} catch (SQLException e) {
			System.out.println("getKommentaaridById SQL error");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return kommentaarid;
	}

	public void postitaKommentaar(String nimi, String tekst, int uudisId) {
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO kommentaar (nimi, tekst, uudisid) "
					+ "VALUES (?, ?, ?)");
			ps.setString(1, nimi);
			ps.setString(2, tekst);
			ps.setInt(3, uudisId);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Kommentaari postitamine ebaõnnestus!");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
	}
	

	public void postitaKommentaar(String nimi, String tekst, int ajakId, int uudisId) {
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO kommentaar (nimi, tekst, uudisid, ajakid) "
					+ "VALUES (?, ?, ?, ?)");
			ps.setString(1, nimi);
			ps.setString(2, tekst);
			ps.setInt(3, uudisId);
			ps.setInt(4, uudisId);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Kommentaari postitamine ebaõnnestus!");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
	}
	
	private Date extractDate(String aeg) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		try {
			date = df.parse(aeg);
		} catch (ParseException e) {
			System.out.println("Kuupäeva parsimise error!");
			e.printStackTrace();
		}
		
		return date;
	}
}
