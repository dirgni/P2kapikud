package service;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.apache.tomcat.util.codec.binary.Base64;

import object.Ajakirjanik;
import connection.DatabaseConnectionFactory;

public class UserService {
	public boolean authenticate(String username, String password) {
		System.out.println("authenticating...");
		boolean loginSuccess = false;
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT kasutajanimi, parool "
					+ "FROM ajakirjanik WHERE kasutajanimi = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			String räsi = null;
			if (rs.isBeforeFirst()) {
				rs.next();
				räsi = rs.getString("parool");
			} else {
				System.out.println("Kasutajanime ei leitud!");
			}
			
			if (password.equals(räsi)) {
				loginSuccess = true;
			}
			
		} catch (SQLException e) {
			System.out.println("authenticate SQL exception");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return loginSuccess;
	}
	
	public Ajakirjanik getAjakirjanikByUsername(String username) {
		System.out.println("getAjakirjanikByUsername");
		Ajakirjanik a = new Ajakirjanik();
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT id, eesnimi, perenimi, roll "
					+ "FROM ajakirjanik WHERE kasutajanimi = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			a = new Ajakirjanik();
			a.setId(rs.getInt("id"));
			a.setEesnimi(rs.getString("eesnimi"));
			a.setPerenimi(rs.getString("perenimi"));
			a.setRoll(rs.getString("roll"));
			
		} catch (SQLException e) {
			System.out.println("authenticate SQL exception");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return a;
	}
	
	public Ajakirjanik getAjakirjanikById(int id) {
		System.out.println("getAjakirjanikById(" + id + ")");
		Ajakirjanik a = new Ajakirjanik();
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT id, eesnimi, perenimi, roll "
					+ "FROM ajakirjanik WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.isBeforeFirst()) {
				rs.next();
				
				a = new Ajakirjanik();
				a.setId(rs.getInt("id"));
				a.setEesnimi(rs.getString("eesnimi"));
				a.setPerenimi(rs.getString("perenimi"));
				a.setRoll(rs.getString("roll"));
			}
			
		} catch (SQLException e) {
			System.out.println("getAjakirjanikById SQL exception");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return a;
	}
	
	public void registerUser(String eesnimi, String perenimi, String kasutajanimi, String parool) {
		randomSalt();
	}
	
	public void registerRSS(String nimi, String email) {
		System.out.println("Registering " + nimi + " for RSS feed...");
		
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement(""
					+ "INSERT INTO rss_tellitud (nimi, email) "
					+ "VALUES (?, ?)");
			ps.setString(1, nimi);
			ps.setString(2, email);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL exception while registering user to RSS");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
	}
	
	private String randomSalt() {
		Random r = new SecureRandom();
		byte[] salt = new byte[32];
		r.nextBytes(salt);

		String encodedSalt = Base64.encodeBase64String(salt);
		
		return encodedSalt;
	}
}
