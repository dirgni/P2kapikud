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
					+ "FROM kommentaar WHERE id = ?");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public void postitaKommentaar(String nimi, String tekst) {
		//TODO
	}
}
