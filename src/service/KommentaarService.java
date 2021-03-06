package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
				k.setUudisId(uudisId);
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
	
	public Kommentaar getKommentaarById(int id) {
		System.out.println("getKommentaarById");
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		Kommentaar k = null;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT id, nimi, tekst, aeg, uudisId "
					+ "FROM kommentaar WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rsKommentaarid = ps.executeQuery();

			Date date;
			DateFormat kell = new SimpleDateFormat("HH:mm:ss");
			DateFormat kuupäev = new SimpleDateFormat("dd-MM-yyyy");
			if (rsKommentaarid.isBeforeFirst()) {
				rsKommentaarid.next();
				k = new Kommentaar();
				k.setId(Integer.parseInt(rsKommentaarid.getString("id")));
				k.setUudisId(rsKommentaarid.getInt("uudisId"));
				k.setNimi(rsKommentaarid.getString("nimi"));
				k.setTekst(rsKommentaarid.getString("tekst"));
				
				date = extractDate(rsKommentaarid.getString("aeg"));
				k.setKell(kell.format(date));
				k.setKuupäev(kuupäev.format(date));
			}
		} catch (SQLException e) {
			System.out.println("getKommentaaridById SQL error");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return k;
	}

	public int postitaKommentaar(String nimi, String tekst, int uudisId) {
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		int kommentaarId = -1;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO kommentaar (nimi, tekst, uudisid) "
					+ "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, nimi);
			ps.setString(2, tekst);
			ps.setInt(3, uudisId);
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			while (rs != null && rs.next()) {
				kommentaarId = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Kommentaari postitamine ebaõnnestus!");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return kommentaarId;
	}
	

	public int postitaKommentaar(String nimi, String tekst, int ajakId, int uudisId) {
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		int kommentaarId = -1;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO kommentaar (nimi, tekst, uudisid, ajakid) "
					+ "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, nimi);
			ps.setString(2, tekst);
			ps.setInt(3, uudisId);
			ps.setInt(4, ajakId);
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			while (rs != null && rs.next()) {
				kommentaarId = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Kommentaari postitamine ebaõnnestus!");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return kommentaarId;
	}
	
	public void kustutaKommentaar(int kId) {
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM kommentaar WHERE id = " + kId);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Kommentaari kustutamine ebaõnnestus!");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
	}
	
	public void kustutaKommentaarid(List<Integer> id) {
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM kommentaar WHERE id = ?");
			
			for (int i = 0; i < id.size(); i++) {
				ps.setInt(1, id.get(i));
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			System.out.println("Kommentaari kustutamine ebaõnnestus!");
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
