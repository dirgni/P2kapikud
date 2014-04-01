// Koostab vajaliku SQL käsu ja võtab andmebaasist andmed. 
// Täidab objektid andmetega ja tagastab.
package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Part;

import object.Uudis;
import connection.DatabaseConnectionFactory;

public class UudisService {
	
	public Uudis getRandomUudis() {
		//TODO
		
		return null;
	}
	
	public ArrayList<Uudis> getKõikUudised() {
		System.out.println("getKõikUudised");
		ArrayList<Uudis> uudised = new ArrayList<Uudis>();
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
				
				ps.setInt(1, id);
				rsKommentaare = ps.executeQuery();
				rsKommentaare.next();
				uudis.setKommentaare(rsKommentaare.getInt("count"));
				
				uudised.add(uudis);
			}
		} catch (SQLException e) {
			System.out.println("getAllUudised  SQLException:");
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
		} finally {
			dcf.closeConnection();
		}
		
		return null;
	}
	
	public void publishUudis(int ajakirjanikId, 
			String pealkiri, String tekst, Part pilt) {
		String piltAsukoht = "";
		piltAsukoht = uploadPicture(pilt);
		
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO uudis (ajakirjanikId, pealkiri, tekst, pilt) "
					+ "VALUES (?, ?, ?, ?)");
			ps.setInt(1, ajakirjanikId);
			ps.setString(2, pealkiri);
			ps.setString(3, tekst);
			ps.setString(4, piltAsukoht);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Uudise postitamine ebaõnnestus! SQLException:");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
	}
	
	/**
	 * 
	 * @return Pildi asukoht
	 */
	public String uploadPicture(Part imgPart) {
		String fileName = getPiltFileName(imgPart);
		File file = new File("git/P2kapikud/WebContent/Images/uudiste_pildid/" + fileName);
		FileOutputStream fos;
		InputStream is;
		
		try {
			is = imgPart.getInputStream();
			fos = new FileOutputStream(file);
			file.createNewFile();
			byte[] buffer = new byte[1024*10];
			int len;
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			fos.close();
		} catch (IOException e) {
			System.out.println("Pildi salvestamine ebaõnnestus!");
			e.printStackTrace();
		} finally {
			
		}

		return fileName;
	}
	
	public Uudis[] search(String pattern) {
		//TODO
		
		return null;
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
	
	private String getPiltFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
	            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	        }
		}
		
		return null;
	}
}
