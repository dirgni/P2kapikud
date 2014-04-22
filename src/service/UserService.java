package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
			PreparedStatement ps = con.prepareStatement("SELECT räsi, sool "
					+ "FROM ajakirjanik WHERE kasutajanimi = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.isBeforeFirst()) {
				rs.next();
				String räsi = rs.getString("räsi");
				String sool = rs.getString("sool");
				
				loginSuccess = verify(sool, räsi, password);
			} else {
				System.out.println("Kasutajanime ei leitud!");
			}
		} catch (SQLException e) {
			System.out.println("authenticate SQL exception");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return loginSuccess;
	}
	
	private boolean verify(String salt, String hash, String parool) {
		if (hash == null) {
			return false;
		}
		MessageDigest sha256;
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
			byte[] passBytes = (salt+parool).getBytes();
			byte[] passHash = sha256.digest(passBytes);
			String genHash = Base64.encodeBase64String(passHash);
			
			if (hash.equals(genHash)) {
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return false;
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
			System.out.println("getAjakirjanikById SQL exception");
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
		System.out.println("Registering user...");
		String sool = randomSalt();
		String räsi = hash(sool, parool);
		String roll = "ajakirjanik";
		
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement(""
					+ "INSERT INTO ajakirjanik (eesnimi, perenimi, "
					+ "kasutajanimi, roll, sool, räsi) "
					+ "VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, eesnimi);
			ps.setString(2, perenimi);
			ps.setString(3, kasutajanimi);
			ps.setString(4, roll);
			ps.setString(5, sool);
			ps.setString(6, räsi);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Registreerimine ebaõnnestus:");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
	}
	
	private String hash(String salt, String parool) {
		MessageDigest sha256;
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
			byte[] passBytes = (salt+parool).getBytes();
			byte[] passHash = sha256.digest(passBytes);
			String hash = Base64.encodeBase64String(passHash);
			
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
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
		byte[] salt = new byte[16];
		r.nextBytes(salt);

		String encodedSalt = Base64.encodeBase64String(salt);
		
		return encodedSalt;
	}

	public boolean FBCheck(String uid) {
		System.out.println("Begin FB check...");
		
		boolean statement = false;
		Ajakirjanik a = new Ajakirjanik();
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT FBuid "
					+ "FROM ajakirjanik WHERE FBuid = ?");
			
			
			ps.setInt(1, Integer.parseInt(uid));
			ResultSet rs = ps.executeQuery();
			
			if (rs.isBeforeFirst()) {
				rs.next();
				String mb = String.valueOf(rs.getInt("FBuid"));
				
				System.out.println(mb+" "+uid);
				if(uid.equals(mb)){
					statement = true;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Check UID Exception");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		return statement;
	}

	public Ajakirjanik getAjakirjanikByUID(String uid) {
		System.out.println("Getting Ajakirjanik by UID");
		
		Ajakirjanik a = new Ajakirjanik();
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		Connection con;
		try {
			con = dcf.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT id, eesnimi, perenimi, roll "
					+ "FROM ajakirjanik WHERE FBuid = ?");
			
			
			ps.setInt(1, Integer.parseInt(uid));
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
			System.out.println("getAjakirjanikByUID SQL exception");
			e.printStackTrace();
		} finally {
			dcf.closeConnection();
		}
		
		return a;
		
	}
}
