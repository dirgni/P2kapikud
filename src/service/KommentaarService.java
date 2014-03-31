package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import object.Kommentaar;
import connection.DatabaseConnectionFactory;

public class KommentaarService {

	public ArrayList<Kommentaar> getKommentaaridByUudisId(int uudisId) {
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT id, nimi, tekst, aeg, uudisId "
					+ "FROM kommentaar WHERE uudisId = ? ORDER BY aeg DESC");
			ps.setInt(1, uudisId);
			ResultSet rsKommentaarid = ps.executeQuery();

			ArrayList<Kommentaar> kommentaarid = new ArrayList<Kommentaar>();

			while (rsKommentaarid.next()) {
				Kommentaar k = new Kommentaar();
				k.setId(Integer.parseInt(rsKommentaarid.getString("id")));
				k.setNimi(rsKommentaarid.getString("nimi"));
				k.setTekst(rsKommentaarid.getString("tekst"));
				k.setAeg(rsKommentaarid.getString("aeg"));
				kommentaarid.add(k);
			}

			return kommentaarid;
		} catch (SQLException e) {
			System.out.println("getKommentaaridById SQL error");
			e.printStackTrace();
		}
		
		return null;
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
		}
		
	}
}
