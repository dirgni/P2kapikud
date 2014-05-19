// Koostab vajaliku SQL käsu ja võtab andmebaasist andmed. 
// Täidab objektid andmetega ja tagastab.
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

import object.Uudis;
import connection.DatabaseConnectionFactory;

public class UudisService {
	
	public Uudis getRandomUudis() {
		//TODO
		
		return null;
	}
	
	public ArrayList<Uudis> getKõikUudised() {
		System.out.println("getKõikUudised");
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		ArrayList<Uudis> uudised = new ArrayList<Uudis>();
		Uudis uudis;
		Date date;
		DateFormat kell = new SimpleDateFormat("HH:mm:ss");
		DateFormat kuupäev = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Connection con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, pealkiri, tekst, pilt, aeg FROM uudis");
			ResultSet rsUudis = ps.executeQuery();
			
			ps = con.prepareStatement("SELECT COUNT(*) FROM kommentaar WHERE uudisId = ? GROUP BY uudisId");
			
			int id;
			ResultSet rsKommentaare;
			while (rsUudis.next()) {
				uudis = new Uudis();

				id = rsUudis.getInt("id");
				uudis.setId(id);
				uudis.setPealkiri(rsUudis.getString("pealkiri"));
				uudis.setTekst(extractParagraphs(rsUudis.getString("tekst")));
				uudis.setPilt(rsUudis.getString("pilt"));
				
				date = extractDate(rsUudis.getString("aeg"));
				uudis.setKell(kell.format(date));
				uudis.setKuupäev(kuupäev.format(date));
				uudis.setKommentaare(0);
				
				ps.setInt(1, id);
				rsKommentaare = ps.executeQuery();
				if (rsKommentaare.isBeforeFirst()) {
					rsKommentaare.next();
					uudis.setKommentaare(rsKommentaare.getInt("count"));
				}
				
				uudised.add(uudis);
			}
		} catch (SQLException e) {
			System.out.println("getKõikUudised SQLException: ");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return uudised;
	}
	
	public ArrayList<Uudis> getUudised(int uudisteArv) {
		System.out.println("getUudised");
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		ArrayList<Uudis> uudised = new ArrayList<Uudis>();
		Uudis uudis;
		Date date;
		DateFormat kell = new SimpleDateFormat("HH:mm:ss");
		DateFormat kuupäev = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Connection con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, pealkiri, tekst, pilt, aeg FROM uudis ORDER BY aeg DESC LIMIT ?");
			ps.setInt(1, uudisteArv);
			ResultSet rsUudis = ps.executeQuery();
			
			int id;
			ResultSet rsKommentaare;
			ps = con.prepareStatement("SELECT COUNT(*) FROM kommentaar WHERE uudisId = ? GROUP BY uudisId");
			while (rsUudis.next()) {
				uudis = new Uudis();

				id = rsUudis.getInt("id");
				uudis.setId(id);
				uudis.setPealkiri(rsUudis.getString("pealkiri"));
				uudis.setTekst(extractParagraphs(rsUudis.getString("tekst")));
				uudis.setPilt(rsUudis.getString("pilt"));
				
				date = extractDate(rsUudis.getString("aeg"));
				uudis.setKell(kell.format(date));
				uudis.setKuupäev(kuupäev.format(date));
				uudis.setKommentaare(0);
				
				// TODO: Eraldi meetodisse
				ps.setInt(1, id);
				rsKommentaare = ps.executeQuery();
				if (rsKommentaare.isBeforeFirst()) {
					rsKommentaare.next();
					uudis.setKommentaare(rsKommentaare.getInt("count"));
				}
				
				uudised.add(uudis);
			}
		} catch (SQLException e) {
			System.out.println("getKõikUudised SQLException: ");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return uudised;
	}
	
	
	
	public Uudis getUudisById(int id) {
		System.out.println("getUudisById");
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Uudis uudis;
		Date date;
		DateFormat kell = new SimpleDateFormat("HH:mm:ss");
		DateFormat kuupäev = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Connection con = dcf.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, pealkiri, tekst, pilt, ajakirjanikId, aeg FROM uudis "
					+ "WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rsUudis = ps.executeQuery();
			
			uudis = new Uudis();
			
			rsUudis.next();
			uudis.setId(rsUudis.getInt("id"));
			uudis.setPealkiri(rsUudis.getString("pealkiri"));
			uudis.setTekst(extractParagraphs(rsUudis.getString("tekst")));
			uudis.setPilt(rsUudis.getString("pilt"));
			uudis.setAjakirjanikId(rsUudis.getInt("ajakirjanikId"));
			uudis.setTagid(getUudisTagid(id));
			
			date = extractDate(rsUudis.getString("aeg"));
			uudis.setKell(kell.format(date));
			uudis.setKuupäev(kuupäev.format(date));
			uudis.setKommentaare(0);
			
			return uudis;
		} catch (SQLException e) {
			System.out.println("getUudisById SQLExcpetion:");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return null;
	}

	public void kustutaUudis(int uId) {
//		KommentaarService ks = new KommentaarService();
//		ArrayList<Kommentaar> kommentaarid = ks.getKommentaaridByUudisId(uId);
//		if (kommentaarid.size() > 0) {
//			ArrayList<Integer> kId = new ArrayList<Integer>();
//			for (int i=0; i<kommentaarid.size(); i++) {
//				kId.add(kommentaarid.get(i).getId());
//			}
//			ks.kustutaKommentaarid(kId);
//		}
		
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM uudis WHERE id = ?");
			ps.setInt(1, uId);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Uudise kustutamine ebaõnnestus!");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
	}
	
	public int publishUudis(int ajakirjanikId, 
			String pealkiri, String tekst, String piltURL, String tagid) {
		System.out.println("PublishUudis");
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		int uudisId = -1;
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO uudis (ajakirjanikId, pealkiri, tekst, pilt) "
					+ "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ajakirjanikId);
			ps.setString(2, pealkiri);
			ps.setString(3, tekst);
			ps.setString(4, piltURL);
			ps.executeUpdate();
			
			// Vaatame, mis id uudis sai
			ResultSet rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
			    uudisId = rs.getInt(1);
			}
			
			lisaTagid(tagid.split(" "), uudisId);
		} catch (SQLException e) {
			System.out.println("Uudise postitamine ebaõnnestus! SQLException:");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return uudisId;
	}
	
	private void lisaTagid(String[] tagid, int uudisId) {
		System.out.println("lisaTagid");
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO uudis_tag (uudisid, tagid)"
					+ "VALUES (?, ?)");
			ps.setInt(1, uudisId);
			for (int i=0; i<tagid.length; i++) {
				int tagId = getTag(tagid[i]);
				ps.setInt(2, tagId);
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
	}
	
	private int getTag(String tag) {
		System.out.println("getTag, tag=" + tag);
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT id FROM tag "
					+ "WHERE nimi = ?");
			ps.setString(1, tag);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.isBeforeFirst()) {
				rs.next();
				return rs.getInt(1);
			} else {
				ps = con.prepareStatement("INSERT INTO tag (nimi) "
						+ "VALUES (?)", Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, tag);
				
				ps.executeUpdate();
				ResultSet rsNewId = ps.getGeneratedKeys();
				rsNewId.next();
				return rsNewId.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return -1;
	}
	
	public ArrayList<Uudis> search(String pattern) {
		System.out.println("search, pattern=" + pattern);
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		ArrayList<Uudis> uudised = new ArrayList<Uudis>();
		Uudis uudis;
		Date date;
		DateFormat kell = new SimpleDateFormat("HH:mm:ss");
		DateFormat kuupäev = new SimpleDateFormat("dd/MM/yyyy");
		int id;
		pattern = '%' + pattern + '%';
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT id, pealkiri, tekst, pilt, aeg FROM uudis "
					+ "WHERE pealkiri ILIKE ? OR tekst ILIKE ?");
			ps.setString(1, pattern);
			ps.setString(2, pattern);
			
			ResultSet rsUudis = ps.executeQuery();
			ResultSet rsKommentaare;
			ps = con.prepareStatement("SELECT COUNT(*) FROM kommentaar WHERE uudisId = ? GROUP BY uudisId");
			while (rsUudis.next()) {
				uudis = new Uudis();

				id = rsUudis.getInt("id");
				uudis.setId(id);
				uudis.setPealkiri(rsUudis.getString("pealkiri"));
				uudis.setTekst(extractParagraphs(rsUudis.getString("tekst")));
				uudis.setPilt(rsUudis.getString("pilt"));
				
				date = extractDate(rsUudis.getString("aeg"));
				uudis.setKell(kell.format(date));
				uudis.setKuupäev(kuupäev.format(date));
				uudis.setKommentaare(0);
				
				// TODO: Eraldi meetodisse
				ps.setInt(1, id);
				rsKommentaare = ps.executeQuery();
				if (rsKommentaare.isBeforeFirst()) {
					rsKommentaare.next();
					uudis.setKommentaare(rsKommentaare.getInt("count"));
				}
				
				uudised.add(uudis);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		return uudised;
	}
	
	private ArrayList<String> extractParagraphs(String tekst) {
		ArrayList<String> lõigud = new ArrayList<String>();
		String[] l = tekst.trim().split("\n");
		
		for (String lõik : l) {
			if (lõik != "") {
				lõigud.add(lõik.trim());
			}
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
	
	private ArrayList<String> getUudisTagid(int uudisId) {
		System.out.println("getUudisTagid");
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		ArrayList<String> tagid = new ArrayList<String>();
		try {
			Connection con = dcf.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
					"SELECT tag.nimi FROM tag, uudis, uudis_tag "
					+ "WHERE uudis.id = ? "
					+ "AND uudis.id = uudis_tag.uudisId "
					+ "AND tag.id = uudis_tag.tagId");
			ps.setInt(1, uudisId);
			ResultSet rsTagid = ps.executeQuery();
			
			while (rsTagid.next()) {
				tagid.add(rsTagid.getString("nimi"));
			}
			
		} catch (SQLException e) {
			System.out.println("getUudisTagid SQLExcpetion:");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return tagid;
	}
}
