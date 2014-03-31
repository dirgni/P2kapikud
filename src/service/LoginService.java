package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import object.Ajakirjanik;
import connection.DatabaseConnectionFactory;

public class LoginService {
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
		System.out.println("getAjakirjanikById");
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
}
